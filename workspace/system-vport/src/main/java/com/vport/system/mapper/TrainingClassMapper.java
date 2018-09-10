package com.vport.system.mapper;

import java.util.List;

import com.github.abel533.mapper.Mapper;
import com.vport.system.pojo.training.TrainingClass;

public interface TrainingClassMapper extends Mapper<TrainingClass>{
    List<TrainingClass> findClassByTrainer(Long trainer);
}
