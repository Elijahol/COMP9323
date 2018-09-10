package com.vport.system.service;

import java.util.List;

import com.vport.system.bean.EvaluateData;
import com.vport.system.pojo.eval.AvgPerformanceData;
import com.vport.system.pojo.eval.GeneralPerformanceDataOrderByTime;
import com.vport.system.pojo.eval.PerformanceAssess;

public interface EvaluateService {
    
    EvaluateData getEvaluateType();
    
    void storePerfomanceData(PerformanceAssess performanceAssess);
    AvgPerformanceData getAvgPerformanceDataByPlayer(Long id);
    List<GeneralPerformanceDataOrderByTime> getGeneralPerformanceWithTimeOrder(Long id);
}
