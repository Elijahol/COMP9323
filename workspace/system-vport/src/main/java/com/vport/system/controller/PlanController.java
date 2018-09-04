package com.vport.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vport.system.bean.PlanTree;
import com.vport.system.bean.ResponseData;
import com.vport.system.service.PlanService;

@Controller
@RequestMapping("plan")
public class PlanController {
    
    @Autowired
    private PlanService planService;
    
    @RequestMapping(value="list",method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getPlanTree(){
        PlanTree planTree = planService.getPlanTree();
        return new ResponseData(200, "yes", planTree.getData());
    }
    
}
