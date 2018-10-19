package com.vport.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vport.system.pojo.eval.EvaluateType;
import com.vport.system.pojo.eval.GeneralPerformanceDataOrderByTime;
import com.vport.system.pojo.eval.PerformanceAssess;
import com.vport.system.pojo.eval.PerformanceContent;
import com.vport.system.pojo.eval.PerformanceForClass;
import com.vport.system.pojo.eval.PerformanceScore;
import com.vport.system.pojo.eval.PerformanceScoreWithTime;
/**
 * EvaluateMapper is dynamic mapper which can be implemented by the framework mybatis.
 * This project applied the plugin jar "com.github.abel533.mapper" which is general mapper
 * encapsulating a series of functions to interact with database 
 * 
 * The github of "com.github.abel533.mapper" is an open source site
 * Gitbub address of the plugin is https://github.com/abel533/Mapper
 * 
 * @author Siyu Wang
 */
public interface EvaluateMapper {
    
    List<EvaluateType> geEvaluateType();

    void insertPerformanceAssess(PerformanceAssess performanceAssess);

    void insertPerformanceContent(PerformanceContent performanceContent);

    List<PerformanceScore> findAvgPerformanceByPlayerId(Long id);

    List<GeneralPerformanceDataOrderByTime> findGeneralPerformanceOrderByTime(Long id);

    List<PerformanceScore> findLastPerformanceByPlayerId(Long id);

    List<PerformanceScoreWithTime> findAvgPerfomanceWithTimeOrder(@Param("studentId")Long id, @Param("typeId")Long type);

    List<PerformanceScore> findAllPerformanceWithTimeOrder(@Param("studentId")Long id, @Param("typeId")Long typeId);

    List<PerformanceForClass> findAvgDataOfClass(@Param("classId")Long classId, @Param("type")Long type);

    List<String> findRecentCommentByPlayer(Long userId);
    
}
