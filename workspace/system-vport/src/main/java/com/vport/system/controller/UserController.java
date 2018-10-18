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
import com.vport.system.utils.MailUtils;
import com.vport.system.utils.UUIDUtils;


/**
 * 
 * 1. This class is a controller to handle the request relating 
 * the user account management.
 * 2. To access this controller, the url must start with "/rest/user/$1", 
 * where $1 is the specific path of a method in this controller.
 * 3. Since the methods of it is relating to the user account such as login, 
 * reset password and so on, this controller will not be intercepted by 
 * "com.vport.system.interceptor.Interceptor"   
 * 
 * 
 * @author Chaoyi Zhou
 */
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
    
    /**
     * Service injection
     */
    @Autowired
    private UserService userService;
    
    /**
     * This method handle the request from "register.jsp",
     * and receive the information that are input by user.
     * it will invoke the method "register" of userService to complete the process.
     * If successful, the user will be redirected and request the login page.
     * If failed, a massage will be provided to user.
     * @param user
     * @param model
     * @return
     * @throws MessageException
     */
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
    /**
     * This method is used to check whether the email input 
     * from the user in the register page has existed in database.
     * If the email has been binded before, return 0 representing 
     * the user can not use this address to register.
     * If the email is new for the databases, return 1 representing 
     * the email is ok for registering.
     * @param email
     * @return
     * @throws IOException
     */
    @RequestMapping(value="checkEmail",method = RequestMethod.POST)
    public String checkEmail(String email) throws IOException{
        User user = new User();
        user.setEmail(email);
        User existUser = userService.findUserByEmail(user);
        if (existUser != null) {
            response.getWriter().println(0);
        }else{
            response.getWriter().println(1);
        }
        return null;
    }
    
    /**
     * The method is to handle the request for activating the account.
     * It will receive the activated code from user where the user click in his email.
     * And it will invoke the methods of userService to complete the activation and update.
     * @param code
     * @param model
     * @return
     */
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
    
    /**
     * This method is handle the login request.
     * It will use the method of userService to find the user through email and password.
     * If the user is null, return "Email or password wrong!" to login page.
     * If the user is not null, but the status of the user is not activated,
     * return "Your account has not been actived!" to login page.
     *  
     * @param user
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(value="login",method=RequestMethod.POST)
    public String login(User user,Model model) throws IOException{
        User existUser = userService.findByEmailandPassword(user);
        if (existUser != null) {
            if (existUser.getStatus() == 0 && existUser.getCode() != null) {
                model.addAttribute("msg", "Your account has not been actived!");
                return "login";
            }
            session.setAttribute("existUser", existUser);
            //if the user click remember me, encrypt the email and password, and set them into cookie
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
        //return the relevant page to user according to the role of it such as instructor or player.
        if (existUser.getRole() != 2) {
            return "trainerMain";
        }else{
            return "stuMain";
        }
        
    }
    
    
    /**
     * Handle the logout and kill the session and the cookie.
     * @return
     */
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
    
    /**
     * If a user want to recover his password, first he need to input his email,
     * and this method will invoke the method of userService to find whether the email exist.
     * @param email
     * @param model
     * @return
     */
    @RequestMapping(value = "recover",method=RequestMethod.POST)
    public String recover(String email,Model model) {
        User user = new User();
        user.setEmail(email);
        User existUser = userService.findUserByEmail(user);
        if (existUser == null) {
            model.addAttribute("error", "We couldn't find your account with that information");
            return "recover";
        }
        session.setAttribute("existUser", existUser);
        //embellish the email address from 20432707@gmail.com to 2******@g***.com
        String start = email.substring(0, 2);
        String sec = email.substring(2,email.indexOf("@")).replaceAll("\\w", "*");
        String end = email.substring(email.indexOf("@")+2, email.length()).replaceAll("\\w", "*");
        String te = start + sec + email.substring(email.indexOf("@"), email.indexOf("@")+2) + end;
       
        model.addAttribute("email", te);
        return "sendEmail";
    }
    
    /**
     * This method will use the method of userService to send the recover email to the user,
     * after the user confirmed the operation.
     * @return
     * @throws MessageException
     */
    @RequestMapping(value = "sendRecover", method=RequestMethod.GET)
    @ResponseBody
    public String sendRecover() throws MessageException {
        User user = (User) session.getAttribute("existUser");
        userService.sendRecoverEmail(user);
        return "1";
    }
    /**
     * this method will use service method to check whether the recover code from user is valid.
     * @param code
     * @param model
     * @return
     */
    @RequestMapping(value="resetPassword",method=RequestMethod.GET)
    public String resetPassword(String code,Model model) {
        User user = userService.findUserbyRecoverCode(code);
        if (user != null) {
            user.setPassword(null);
            model.addAttribute("user", user);
            return "resetPassword";
        }
        return null;
    }
    
    /**
     * This method is to use service to complete the password process
     * @param user
     * @return
     */
    @RequestMapping(value="changePassword",method=RequestMethod.POST)
    @ResponseBody
    public String changePassword(@RequestBody User user) {
        userService.updateUserSelective(user);
        return "1";
    }
}
