package com.vport.system.mapper;

import java.util.List;

import com.vport.system.pojo.eval.EvaluateType;
import com.vport.system.pojo.eval.GeneralPerformanceDataOrderByTime;
import com.vport.system.pojo.eval.PerformanceAssess;
import com.vport.system.pojo.eval.PerformanceContent;
import com.vport.system.pojo.eval.PerformanceScore;

public interface EvaluateMapper {
    
    List<EvaluateType> geEvaluateType();

    void insertPerformanceAssess(PerformanceAssess performanceAssess);

    void insertPerformanceContent(PerformanceContent performanceContent);

    List<PerformanceScore> findAvgPerformanceByPlayerId(Long id);

    List<GeneralPerformanceDataOrderByTime> findGeneralPerformanceOrderByTime(Long id);
    
}
