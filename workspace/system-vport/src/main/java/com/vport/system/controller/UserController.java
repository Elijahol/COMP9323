package com.vport.system.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.vport.system.bean.ResponseData;
import com.vport.system.exception.MessageException;
import com.vport.system.pojo.person.User;
import com.vport.system.service.UserService;
import com.vport.system.utils.EncryptUtil;
import com.vport.system.utils.UUIDUtils;

@Controller
@RequestMapping("user")
public class UserController {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
   
   
    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request,HttpServletResponse response){
        this.request = request;
        this.response = response;
        this.session = request.getSession();
    }
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value="register",method = RequestMethod.POST)
    public String register(User user,Model model) throws MessageException{
        try{
            userService.register(user);
            return "redirect:/rest/page/login";
        }catch(Exception e){
            model.addAttribute("msg","register fialed");
            return "register";
        }
        
    }
    
    @RequestMapping(value="checkEmail",method = RequestMethod.POST)
    public String checkEmail(String email) throws IOException{
        System.out.println(email);
        User user = new User();
        user.setEmail(email);
        User existUser = userService.findByEmailandPassword(user);
        if (existUser != null) {
            response.getWriter().println(0);
        }else{
            response.getWriter().println(1);
        }
        return null;
    }
    @RequestMapping(value="activate",method=RequestMethod.GET)
    public String activate(String code,Model model){
        User user = userService.findUserByCode(code);
        if (user != null) {
            user.setCode(null);
            user.setStatus(1);
            userService.updateUser(user);
            return "redirect:/rest/page/login";
        }
        return null;
        
    }
    
    @RequestMapping(value="login",method=RequestMethod.POST)
    public String login(User user,Model model) throws IOException{
        User existUser = userService.findByEmailandPassword(user);
        if (existUser != null) {
            if (existUser.getStatus() == 0 && existUser.getCode() != null) {
                model.addAttribute("msg", "Your account has not been actived!");
                return "login";
            }
            session.setAttribute("existUser", existUser);
            String remember = request.getParameter("remember");
            if ("1".equals(remember)) {
                String email = EncryptUtil.encrypt(existUser.getEmail());
                String password = EncryptUtil.encrypt(existUser.getPassword());
                Cookie cookie = new Cookie("SESSION_USER", email+"#"+password);
                cookie.setPath("/");
                cookie.setMaxAge(24*60*60);
                response.addCookie(cookie);
            }
           
        }else{
            model.addAttribute("msg", "Email or password wrong!");
            return "login";
        }
        //判断是教练还是球员
        if (existUser.getRole() == 1) {
            return "trainerMain";
        }else{
            return "stuMain";
        }
        
    }
    @RequestMapping(value="logout",method=RequestMethod.GET)
    public String logout(){
        session.removeAttribute("existUser");
        session.invalidate();
        Cookie cookie = new Cookie("SESSION_USER", "");
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "login";
    }
}
