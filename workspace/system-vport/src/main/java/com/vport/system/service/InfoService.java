package com.vport.system.service;

import java.util.List;
import java.util.Map;

import com.vport.system.pojo.Info;

public interface InfoService {
    void addNewPlanInfoToStu(Long schemaId,Long classId);
    List<Info> getAllInfoByUser(Long userId);
    void changeInfoStatus(Long id);
    void deleteInfoByUser(Long id);
    void addNewEvalInfo(Long player);
    void addNewCourseInfo(Long classId);
    void addNewJoinInfo(Long id, Long classId);
}
