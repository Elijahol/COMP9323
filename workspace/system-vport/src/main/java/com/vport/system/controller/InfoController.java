package com.vport.system.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vport.system.pojo.Info;
import com.vport.system.pojo.person.User;
import com.vport.system.service.InfoService;

@Controller
@RequestMapping("info")
public class InfoController {
    @Autowired
    private InfoService infoService;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
   
   
    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request,HttpServletResponse response){
        this.request = request;
        this.response = response;
        this.session = request.getSession();
    }
    
    
    /**
     * 得到所有通知
     * @return
     */
    @RequestMapping(value="allInfo",method=RequestMethod.GET)
    @ResponseBody
    public List<Info> getAllInfo(){
        User user = (User) session.getAttribute("existUser");
        return infoService.getAllInfoByUser(user.getId());
        
    }
    /**
     * 改变通知状态
     */
    @RequestMapping(value="changeInfo",method=RequestMethod.POST)
    public void changeInfo(Long id) {
        infoService.changeInfoStatus(id);
    }
    /**
     * 清空通知
     */
    @RequestMapping(value="deleteInfo",method=RequestMethod.POST)
    @ResponseBody
    public Integer clearAll() {
        User user = (User) session.getAttribute("existUser");
        try{
            infoService.deleteInfoByUser(user.getId());
            return 1;
        }catch (Exception e) {
            return 0;
        }
    }
    
}
