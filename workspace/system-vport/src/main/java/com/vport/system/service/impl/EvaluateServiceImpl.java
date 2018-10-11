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

@Service
public class EvaluateServiceImpl implements EvaluateService {
    
    @Autowired
    private EvaluateMapper evaluateMapper;
    
    @Autowired
    private InfoService infoService;
    
    /**
     * 获取评估内容
     */
    @Override
    public EvaluateData getEvaluateType() {
        List<EvaluateType> list = evaluateMapper.geEvaluateType();
        EvaluateData evaluateData = new EvaluateData();
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
     * 存储针对一个学生的评估数据
     */
    @Override
    public void storePerfomanceData(PerformanceAssess performanceAssess) {
        performanceAssess.setTime(new Date());
        evaluateMapper.insertPerformanceAssess(performanceAssess);
        List<PerformanceContent> performanceContents = performanceAssess.getPerformanceContents();
        for (PerformanceContent performanceContent : performanceContents) {
            performanceContent.setAssessId(performanceAssess.getId());
            evaluateMapper.insertPerformanceContent(performanceContent);
        }
        
        infoService.addNewEvalInfo(performanceAssess.getPlayer());
        
    }
    /**
     * 得到关于一个学生的平均值训练数据,放到map中
     */
    @Override
    public void getAvgPerformanceDataByPlayer(Long id,Map<String, List<?>> data) {
        List<PerformanceScore> list = evaluateMapper.findAvgPerformanceByPlayerId(id);
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
     * 得到关于一个学生最近一个的训练数据，放到map中
     */
    @Override
    public void getLastPerformanceDataByPlayer(Long id, Map<String, List<?>> data) {
        List<PerformanceScore> list = evaluateMapper.findLastPerformanceByPlayerId(id);
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
     * 按照时间顺序，得到球员每次的总体平均分
     */
    @Override
    public List<GeneralPerformanceDataOrderByTime> getGeneralPerformanceWithTimeOrder(Long id) {
        List<GeneralPerformanceDataOrderByTime> result = evaluateMapper.findGeneralPerformanceOrderByTime(id);
        return result;
    }
    
    /**
     * 按照时间孙旭，得到球员每次的平均分
     */
    @Override
    public void getAvgPerformanceDataWithTimeOrder(Long id, Map<String, List<?>> data) {
        List<PerformanceScoreWithTime> skillsByTimeData = evaluateMapper.findAvgPerfomanceWithTimeOrder(id,1L);
        List<PerformanceScoreWithTime> physicalByTimeData = evaluateMapper.findAvgPerfomanceWithTimeOrder(id,2L);
        data.put("skillsByTimeData", skillsByTimeData);
        data.put("physicalByTimeData", physicalByTimeData);
        
    }
    /**
     * 按照时间顺序，得到学员全部的评估数据
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
     * 获得班级训练建议
     *  1.文字部分：技术部分那一项最低，体能部分那一项最低
     *  2.技术部分的平均分：6项
     *  3.技术部分的平均：5项
     *  结果集用map
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
    @Override
    public String getRecentCommet(Long userId) {
        List<String> comments = evaluateMapper.findRecentCommentByPlayer(userId);
        if (comments != null && comments.size() != 0) {
            return comments.get(0);
        }
        return "";
        
    }
}
