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
/**
 * InfoController is the entrance of the notification module.
 * This controller provides the operations of notification
 * such as get the notifications of a user, change the status of a notification
 * from unread to read and so on.
 * Since the notification function of the front end apply async loading, the 
 * responses of the methods in this class is mainly asynchronous or void
 * 
 * @author Liling Zhang
 *
 */
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
     * Handle the request to get the all notifications of a user
     * and response the information in the format with json 
     * @return
     */
    @RequestMapping(value="allInfo",method=RequestMethod.GET)
    @ResponseBody
    public List<Info> getAllInfo(){
        User user = (User) session.getAttribute("existUser");
        return infoService.getAllInfoByUser(user.getId());
        
    }
    /**
     * If the user click the notification, the request will asyncly 
     * send the request to apply change the status of the notification
     */
    @RequestMapping(value="changeInfo",method=RequestMethod.POST)
    public void changeInfo(Long id) {
        infoService.changeInfoStatus(id);
    }
    /**
     * If the user click the "clear all", the reuqest will asyncly
     * send the request to apply delete all the current notifications
     *  
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
