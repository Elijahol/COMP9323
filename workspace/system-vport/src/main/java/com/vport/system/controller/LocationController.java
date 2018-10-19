package com.vport.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vport.system.service.CourseService;
/**
 * LocationController is to support the formal address of the
 * training course.
 * @author Liling Zhang
 *
 */
@Controller
@RequestMapping(value="location")
public class LocationController {
    
    @Autowired
    private CourseService courseService;
    /**
     * This method is to get the request about getting
     * the location of the course by using classId and the short name of the
     * place.
     * @param classId
     * @param place
     * @param model
     * @return
     */
    @RequestMapping(value="toMap",method=RequestMethod.GET)
    public String toMap(String classId, String place,Model model){
        String addr = courseService.findFullAddress(classId,place);
        model.addAttribute("addr", addr);
        return "location";
    }
}
