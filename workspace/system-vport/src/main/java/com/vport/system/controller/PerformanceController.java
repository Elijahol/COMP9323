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

@Controller
@RequestMapping(value="performance")
public class PerformanceController {
    
    @Autowired
    private EvaluateService evaluateService;
    
    @RequestMapping(value="getEvaluateData",method = RequestMethod.GET)
    @ResponseBody
    public EvaluateData getEvaluateData(){
        EvaluateData evaluateType = evaluateService.getEvaluateType();
        return evaluateType;
    }
    @RequestMapping(value="storeEvaluateData",method = RequestMethod.POST)
    @ResponseBody
    public String storeEvaluateData(@RequestBody PerformanceAssess performanceAssess){
        evaluateService.storePerfomanceData(performanceAssess);
        return "1";
    }
    
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
