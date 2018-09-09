package com.vport.system.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vport.system.bean.EvaluateData;
import com.vport.system.bean.ResponseData;
import com.vport.system.service.EvaluateService;

@Controller
@RequestMapping(value="performance")
public class PerformanceController {
    
    @Autowired
    private EvaluateService evaluateService;
    
    @RequestMapping(value="getEvaluateData",method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getEvaluateData(){
        EvaluateData evaluateType = evaluateService.getEvaluateType();
        List<EvaluateData> list = new ArrayList<EvaluateData>();
        list.add(evaluateType);
        ResponseData responseData = new ResponseData(0, "", list);
        return responseData;
    }
}
