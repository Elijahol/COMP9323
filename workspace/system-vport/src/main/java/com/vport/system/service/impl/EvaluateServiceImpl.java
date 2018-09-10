package com.vport.system.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vport.system.bean.EvaluateData;
import com.vport.system.mapper.EvaluateMapper;
import com.vport.system.pojo.eval.AvgPerformanceData;
import com.vport.system.pojo.eval.EvaluateType;
import com.vport.system.pojo.eval.GeneralPerformanceDataOrderByTime;
import com.vport.system.pojo.eval.PerformanceAssess;
import com.vport.system.pojo.eval.PerformanceContent;
import com.vport.system.pojo.eval.PerformanceScore;
import com.vport.system.service.EvaluateService;
import com.vport.system.utils.DateUtil;

@Service
public class EvaluateServiceImpl implements EvaluateService {
    
    @Autowired
    private EvaluateMapper evaluateMapper;
    
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
        
    }
    /**
     * 得到关于一个学生的平均值训练数据
     */
    @Override
    public AvgPerformanceData getAvgPerformanceDataByPlayer(Long id) {
        List<PerformanceScore> list = evaluateMapper.findAvgPerformanceByPlayerId(id);
        AvgPerformanceData avgPerformanceData = new AvgPerformanceData();
        List<PerformanceScore>  cognitiveTechniques = new ArrayList<>();
        List<PerformanceScore> athleticAbility = new ArrayList<>();
        for (PerformanceScore performanceScore : list) {
            if (performanceScore.getTypeId() == 1L) {
                cognitiveTechniques.add(performanceScore);
            }else{
                athleticAbility.add(performanceScore);
            }
        }
        avgPerformanceData.setCognitiveTechniques(cognitiveTechniques);
        avgPerformanceData.setAthleticAbility(athleticAbility);
        return avgPerformanceData;
    }
    
    /**
     * 按照时间顺序，得到球员每次的总体平均分
     */
    @Override
    public List<GeneralPerformanceDataOrderByTime> getGeneralPerformanceWithTimeOrder(Long id) {
        List<GeneralPerformanceDataOrderByTime> result = evaluateMapper.findGeneralPerformanceOrderByTime(id);
        return result;
    }
    
    
}
