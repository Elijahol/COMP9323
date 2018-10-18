package com.vport.system.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vport.system.bean.ResponseData;
import com.vport.system.pojo.person.User;
import com.vport.system.service.UserService;
import com.vport.system.utils.CookieUtils;
import com.vport.system.utils.EncryptUtil;

/**
 * Since the html pages and jsp pages are located into the WEB-INFO,
 * this controller handle the all request of the jsp or html page.
 * Also, this controller need to achieve the auto loging function
 * by check the cookies of the request.
 * @author Chaoyi Zhou
 */
@Controller
@RequestMapping("page")
public class PageController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "{pageName}", method = RequestMethod.GET)
    public String toPage(@PathVariable("pageName") String pageName,HttpServletRequest request,HttpServletResponse response) throws IOException{
        if ("login".equals(pageName)) {
            Cookie[] cookies = request.getCookies();
            Cookie sessionUserCookie = CookieUtils.findCookie(cookies, "SESSION_USER");
            if (sessionUserCookie != null) {
                String[] emialAndPasswordWithEcrypts = sessionUserCookie.getValue().split("#");
                String email = EncryptUtil.decrypt(emialAndPasswordWithEcrypts[0]);
                String password = EncryptUtil.decrypt(emialAndPasswordWithEcrypts[1]);
                
                User user = new User();
                user.setEmail(email);
                user.setPassword(password);
                User existUser = userService.findByEmailandPassword(user);
                if (existUser != null) {
                    request.getSession().setAttribute("existUser", existUser);
                    if (existUser.getRole() != 2) {
                        return "trainerMain";
                    }else{
                        return "stuMain";
                    }
                }
            }
        }
        return pageName;
    }
}
