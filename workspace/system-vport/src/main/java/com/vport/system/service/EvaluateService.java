package com.vport.system.service;

import java.util.List;
import java.util.Map;

import com.vport.system.bean.EvaluateData;
import com.vport.system.pojo.eval.AvgPerformanceData;
import com.vport.system.pojo.eval.GeneralPerformanceDataOrderByTime;
import com.vport.system.pojo.eval.PerformanceAssess;

public interface EvaluateService {
    
    EvaluateData getEvaluateType();
    
    void storePerfomanceData(PerformanceAssess performanceAssess);
    void getAvgPerformanceDataByPlayer(Long id,Map<String, List<?>> data);
    void getLastPerformanceDataByPlayer(Long id,Map<String, List<?>> data);
    List<GeneralPerformanceDataOrderByTime> getGeneralPerformanceWithTimeOrder(Long id);

    void getAvgPerformanceDataWithTimeOrder(Long id, Map<String, List<?>> data);

    void getPerformanceScoreByTimeOrder(Long id, Map<String, List<?>> data);
}
