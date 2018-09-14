package com.vport.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vport.system.pojo.eval.EvaluateType;
import com.vport.system.pojo.eval.GeneralPerformanceDataOrderByTime;
import com.vport.system.pojo.eval.PerformanceAssess;
import com.vport.system.pojo.eval.PerformanceContent;
import com.vport.system.pojo.eval.PerformanceScore;
import com.vport.system.pojo.eval.PerformanceScoreWithTime;

public interface EvaluateMapper {
    
    List<EvaluateType> geEvaluateType();

    void insertPerformanceAssess(PerformanceAssess performanceAssess);

    void insertPerformanceContent(PerformanceContent performanceContent);

    List<PerformanceScore> findAvgPerformanceByPlayerId(Long id);

    List<GeneralPerformanceDataOrderByTime> findGeneralPerformanceOrderByTime(Long id);

    List<PerformanceScore> findLastPerformanceByPlayerId(Long id);

    List<PerformanceScoreWithTime> findAvgPerfomanceWithTimeOrder(@Param("studentId")Long id, @Param("typeId")Long type);

    List<PerformanceScore> findAllPerformanceWithTimeOrder(@Param("studentId")Long id, @Param("typeId")Long typeId);
    
}
