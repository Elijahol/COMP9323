/*package com.vport.system.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vport.system.bean.ResponseData;
import com.vport.system.pojo.person.User;

@Controller
@RequestMapping("page")
public class PageController2 {
    @RequestMapping(value = "{pageName}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData toPage(@PathVariable("pageName") String pageName,HttpServletRequest request,HttpServletResponse response) throws IOException{
        HttpSession session = request.getSession();
        System.out.println(session.getId());
        User user = (User) session.getAttribute("existUser");
        ResponseData responseData = null;
        if (user == null) {
            responseData = new ResponseData(1, "", null);
        }else{
            List<User> list = new ArrayList<User>();
            list.add(user);
            responseData = new ResponseData(0, "", list);
        }
        
        return responseData;
    }
}
*/