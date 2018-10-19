package com.vport.system.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vport.system.bean.EvaluateData;
import com.vport.system.mapper.EvaluateMapper;
import com.vport.system.pojo.eval.EvaluateType;
import com.vport.system.pojo.eval.GeneralPerformanceDataOrderByTime;
import com.vport.system.pojo.eval.PerformanceAssess;
import com.vport.system.pojo.eval.PerformanceContent;
import com.vport.system.pojo.eval.PerformanceForClass;
import com.vport.system.pojo.eval.PerformanceScore;
import com.vport.system.pojo.eval.PerformanceScoreWithTime;
import com.vport.system.service.EvaluateService;
import com.vport.system.service.InfoService;
/**
 * This Class is an implementation of the interface EvaluateService.
 * The main function of this class is to complete the business logic 
 * relating to training data and performance assessment.
 * @author Siyu Wang
 *
 */
@Service
public class EvaluateServiceImpl implements EvaluateService {
    
    @Autowired
    private EvaluateMapper evaluateMapper;
    
    @Autowired
    private InfoService infoService;
    
    /**
     * This method is to get the performance assessment types and contents
     * by using the dynamic mapper "evaluateMapper" to get the data from
     * database.
     */
    @Override
    public EvaluateData getEvaluateType() {
        // get all types from database
        List<EvaluateType> list = evaluateMapper.geEvaluateType();
        EvaluateData evaluateData = new EvaluateData();
        //separate the types into "Cognitive Techniques" and "Physical ability"
        for (EvaluateType evaluateType : list) {
            if ("Cognitive Techniques".equals(evaluateType.getName())) {
                evaluateData.setCognitiveTechniques(evaluateType);
            }else{
                evaluateData.setAthleticAbility(evaluateType);
            }
        }
        return evaluateData;
    }
    /**
     * This method is to store a performance assessment data of a player
     * 
     */
    @Override
    public void storePerfomanceData(PerformanceAssess performanceAssess) {
        performanceAssess.setTime(new Date());
        //insert this data into the table "performance_assess"
        evaluateMapper.insertPerformanceAssess(performanceAssess);
        //insert each specific performance assessment content into the table "performance content"
        List<PerformanceContent> performanceContents = performanceAssess.getPerformanceContents();
        for (PerformanceContent performanceContent : performanceContents) {
            performanceContent.setAssessId(performanceAssess.getId());
            evaluateMapper.insertPerformanceContent(performanceContent);
        }
        
        infoService.addNewEvalInfo(performanceAssess.getPlayer());
        
    }
    /**
     * This method is to get the avg performance data of a player
     * and put the data into a map 
     */
    @Override
    public void getAvgPerformanceDataByPlayer(Long id,Map<String, List<?>> data) {
        //get the avg data from database according to player id
        List<PerformanceScore> list = evaluateMapper.findAvgPerformanceByPlayerId(id);
        //separate the data into skill part and physical part
        List<PerformanceScore>  skillsAverageData = new ArrayList<>();
        List<PerformanceScore> physicalAverageData = new ArrayList<>();
        for (PerformanceScore performanceScore : list) {
            if (performanceScore.getTypeId() == 1L) {
                skillsAverageData.add(performanceScore);
            }else{
                physicalAverageData.add(performanceScore);
            }
        }
        data.put("skillsAverageData", skillsAverageData);
        data.put("physicalAverageData", physicalAverageData);
    }
    
    /**
     * This method is to get the most recent performance assessment data of a player,
     * and put the data into the map
     */
    @Override
    public void getLastPerformanceDataByPlayer(Long id, Map<String, List<?>> data) {
        //get the most recent data according the player id
        List<PerformanceScore> list = evaluateMapper.findLastPerformanceByPlayerId(id);
        //separate the data into skill part and physical part
        List<PerformanceScore>  skillsLastTimeData = new ArrayList<>();
        List<PerformanceScore> physicalLastTimeData = new ArrayList<>();
        for (PerformanceScore performanceScore : list) {
            if (performanceScore.getTypeId() == 1L) {
                skillsLastTimeData.add(performanceScore);
            }else{
                physicalLastTimeData.add(performanceScore);
            }
        }
        data.put("skillsLastTimeData", skillsLastTimeData);
        data.put("physicalLastTimeData", physicalLastTimeData);
        
    }
    /**
     * This method is to get the general performance score of a player with asc time order
     */
    @Override
    public List<GeneralPerformanceDataOrderByTime> getGeneralPerformanceWithTimeOrder(Long id) {
        List<GeneralPerformanceDataOrderByTime> result = evaluateMapper.findGeneralPerformanceOrderByTime(id);
        return result;
    }
    
    /**
     * This method is to get the avg performance with the time order 
     */
    @Override
    public void getAvgPerformanceDataWithTimeOrder(Long id, Map<String, List<?>> data) {
        //get the score of each performance type in skill part
        List<PerformanceScoreWithTime> skillsByTimeData = evaluateMapper.findAvgPerfomanceWithTimeOrder(id,1L);
        //get the score of each performance type in physical part
        List<PerformanceScoreWithTime> physicalByTimeData = evaluateMapper.findAvgPerfomanceWithTimeOrder(id,2L);
        data.put("skillsByTimeData", skillsByTimeData);
        data.put("physicalByTimeData", physicalByTimeData);
        
    }
    /**
     * This method is to get the whole performance data of a player by the time order
     * and separate these data into the same type array
     * eg: front hand [4,5,3,2,1] with time order
     */
    @Override
    public void getPerformanceScoreByTimeOrder(Long id, Map<String, List<?>> data) {
        List<PerformanceScore> skills = evaluateMapper.findAllPerformanceWithTimeOrder(id,1L);
        List<PerformanceScore> physical = evaluateMapper.findAllPerformanceWithTimeOrder(id,2L);
        if (!skills.isEmpty()) {
            Date tarTime = skills.get(0).getTime();
            List<List<PerformanceScore>> skillsScoreByTime = new ArrayList<>();
            List<PerformanceScore> skillList = new ArrayList<>();
            for (PerformanceScore pf : skills) {
                if(!pf.getTime().equals(tarTime)){
                    skillsScoreByTime.add(skillList);
                    skillList = new ArrayList<>();
                    tarTime = pf.getTime();
                }
                skillList.add(pf);
            }
            skillsScoreByTime.add(skillList);
            tarTime = physical.get(0).getTime();
            List<List<PerformanceScore>> physicalScoreByTime = new ArrayList<>();
            List<PerformanceScore> physicalList = new ArrayList<>();
            for (PerformanceScore pf : physical) {
                if(!pf.getTime().equals(tarTime)){
                    physicalScoreByTime.add(physicalList);
                    physicalList = new ArrayList<>();
                    tarTime = pf.getTime();
                }
                physicalList.add(pf);
            }
            physicalScoreByTime.add(physicalList);
            data.put("skillsScoreByTime", skillsScoreByTime);
            data.put("physicalScoreByTime", physicalScoreByTime);
        }
        
    }
    
    /**
     * This method is to get the suggestion to support the trainer to learn
     * the training effect of the class
     *  1.text part：find the two lowest types in skill and physical
     *  2.avg score of skill part：6 types
     *  3.avg score of physical part：5 types
     *  put the data into map
     * @throws IOException 
     */
    @Override
    public Map<String, Object> getAdviceAndDataForClass(Long classId) throws IOException {
        Map<String, Object> map = new HashMap<>();
        Properties properties = new Properties();
        List<PerformanceForClass> skills = evaluateMapper.findAvgDataOfClass(classId,1L);
        List<PerformanceForClass> physical = evaluateMapper.findAvgDataOfClass(classId,2L);
        map.put("skills", skills);
        map.put("physical", physical);
        List<PerformanceForClass> skillMins = getLowest(skills);
        List<PerformanceForClass> physicalMins = getLowest(physical);
        
        InputStream in = EvaluateServiceImpl.class.getClassLoader().getResourceAsStream("advice.properties");
        properties.load(in);
        
        String params[] = {skillMins.get(0).getName(),skillMins.get(0).getScore()+"",skillMins.get(1).getName(),skillMins.get(1).getScore()+"",
                physicalMins.get(0).getName(),physicalMins.get(0).getScore()+"",physicalMins.get(1).getName(),physicalMins.get(1).getScore()+""};
        String msg = MessageFormat.format(properties.getProperty("msg"), params);
        map.put("advice", msg);
        return map;
    }
    /**
     * Find the most recent comment that the trainer provide to the player
     */
    @Override
    public String getRecentCommet(Long userId) {
        List<String> comments = evaluateMapper.findRecentCommentByPlayer(userId);
        if (comments != null && comments.size() != 0) {
            return comments.get(0);
        }
        return "";
        
    }
    /**
     * find the lowest score from the list containing the performance data
     * @param list
     * @return
     */
    private List<PerformanceForClass> getLowest(List<PerformanceForClass> list){
        List<PerformanceForClass> list2 = new ArrayList<>();
        for (PerformanceForClass performanceForClass : list) {
            PerformanceForClass class1 = new PerformanceForClass();
            class1.setChName(performanceForClass.getChName());
            class1.setName(performanceForClass.getName());
            class1.setScore(performanceForClass.getScore());
            list2.add(class1);
        }
        Collections.sort(list2);
        return list2;
    }
   
}
