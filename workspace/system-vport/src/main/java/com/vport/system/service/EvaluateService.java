package com.vport.system.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.vport.system.bean.EvaluateData;
import com.vport.system.pojo.eval.AvgPerformanceData;
import com.vport.system.pojo.eval.GeneralPerformanceDataOrderByTime;
import com.vport.system.pojo.eval.PerformanceAssess;
import com.vport.system.pojo.eval.PerformanceForClass;

public interface EvaluateService {
    
    EvaluateData getEvaluateType();
    
    void storePerfomanceData(PerformanceAssess performanceAssess);
    void getAvgPerformanceDataByPlayer(Long id,Map<String, List<?>> data);
    void getLastPerformanceDataByPlayer(Long id,Map<String, List<?>> data);
    List<GeneralPerformanceDataOrderByTime> getGeneralPerformanceWithTimeOrder(Long id);

    void getAvgPerformanceDataWithTimeOrder(Long id, Map<String, List<?>> data);

    void getPerformanceScoreByTimeOrder(Long id, Map<String, List<?>> data);
    Map<String, Object> getAdviceAndDataForClass(Long classId)  throws IOException;

    String getRecentCommet(Long userId);
}
