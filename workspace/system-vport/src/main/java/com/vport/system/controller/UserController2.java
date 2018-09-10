/*package com.vport.system.controller;

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
import com.vport.system.utils.UUIDUtils;

@Controller
@RequestMapping("user")
public class UserController2 {
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
    @ResponseBody
    public ResponseData register(@RequestBody User user) throws MessageException{
        ResponseData responseData = null;
        try{
            userService.register(user);
            responseData = new ResponseData(0, "", null);
        }catch(Exception e){
            responseData = new ResponseData(1, "", null);
        }
        return responseData;
        
    }
    
    @RequestMapping(value="checkEmail",method = RequestMethod.POST)
    public String checkEmail(String email) throws IOException{
        User user = new User();
        user.setEmail(email);
        User existUser = userService.findByEmailandPassword(user);
        if (existUser != null) {
            response.getWriter().println(0);
        }else{
            response.getWriter().println(1);
        }
        System.out.println(request.getSession().getId());
        return null;
    }
    @RequestMapping(value="activate",method=RequestMethod.GET)
    public String activate(String code,Model model){
        User user = userService.findUserByCode(code);
        if (user != null) {
            user.setCode(null);
            user.setStatus(1);
            userService.updateUser(user);
            return "redirect://www.vport.com/login";
        }
        return null;
        
    }
    
    @RequestMapping(value="login",method=RequestMethod.POST)
    @ResponseBody
    public ResponseData login(@RequestBody User user) throws IOException{
        User existUser = userService.findByEmailandPassword(user);
        ResponseData responseData = null;
        if (existUser != null) {
            if (existUser.getStatus() == 0 && existUser.getCode() != null) {
                responseData = new ResponseData(1, "账号未激活哦", null);
                return responseData;
            }
            System.out.println(request.getSession().getId());
            System.out.println(session.getId());
            session.setAttribute("existUser", existUser);
            Cookie cookie = new Cookie("SESSION_USER", existUser.getEmail()+"#"+existUser.getPassword());
            cookie.setPath("/");
            cookie.setMaxAge(24*60*60);
            response.addCookie(cookie);
            List<User> list = new ArrayList<User>();
            list.add(existUser);
            responseData =  new ResponseData(0, "", list);
        }else{
            responseData = new ResponseData(1, "用户名或密码错误", null);
        }
        System.out.println(request.getSession().getId());
        return responseData;
    }
    @RequestMapping(value="logout",method=RequestMethod.GET)
    @ResponseBody
    public ResponseData logout(){
        session.removeAttribute("existUser");
        session.invalidate();
        Cookie cookie = new Cookie("SESSION_USER", "");
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return new ResponseData(0, "", null);
    }
}
*/