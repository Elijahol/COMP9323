package com.vport.system.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vport.system.bean.EvaluateData;
import com.vport.system.bean.ResponseData;
import com.vport.system.pojo.eval.PerformanceAssess;
import com.vport.system.service.EvaluateService;
/**
 * PerformanceController is to handle the requests from front end
 * about operations of the training data and performance assessment.
 * Since these operations are all async, the methods return json format
 * @author Siyu Wang
 *
 */
@Controller
@RequestMapping(value="performance")
public class PerformanceController {
    
    @Autowired
    private EvaluateService evaluateService;
    
    /**
     * This method is to return the evaluation content to front end
     * by using evaluateService. 
     * @return
     */
    @RequestMapping(value="getEvaluateData",method = RequestMethod.GET)
    @ResponseBody
    public EvaluateData getEvaluateData(){
        EvaluateData evaluateType = evaluateService.getEvaluateType();
        return evaluateType;
    }
    /**
     * This method is to use service to store a performance assessment result
     * of a player.
     * @param performanceAssess
     * @return
     */
    @RequestMapping(value="storeEvaluateData",method = RequestMethod.POST)
    @ResponseBody
    public String storeEvaluateData(@RequestBody PerformanceAssess performanceAssess){
        evaluateService.storePerfomanceData(performanceAssess);
        return "1";
    }
    /**
     * This method is to handle the request to get the suggestions about 
     * a training class. The method will use service to get a map containing relevant data
     * and return json format
     * @param classId
     * @return
     */
    @RequestMapping(value="suggestion",method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getSuggestion(Long classId){
        try {
           return evaluateService.getAdviceAndDataForClass(classId);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
