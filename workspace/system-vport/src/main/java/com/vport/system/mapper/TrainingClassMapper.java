package com.vport.system.mapper;

import java.util.List;

import com.github.abel533.mapper.Mapper;
import com.vport.system.pojo.training.TrainingClass;
/**
 * TrainingClassMapper is dynamic mapper which can be implemented by the framework mybatis.
 * This project applied the plugin jar "com.github.abel533.mapper" which is general mapper
 * encapsulating a series of functions to interact with database 
 * 
 * The github of "com.github.abel533.mapper" is an open source site
 * Gitbub address of the plugin is https://github.com/abel533/Mapper
 * 
 * @author Siyu Wang
 */
public interface TrainingClassMapper extends Mapper<TrainingClass>{
    List<TrainingClass> findClassByTrainer(Long trainer);
}
