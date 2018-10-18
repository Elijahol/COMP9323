package com.vport.system.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.vport.system.pojo.person.User;

public class Interceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        if (requestURI.contains("/page/login")
                ||requestURI.contains("/page/recover")
                ||requestURI.contains("/page/register")
                ||requestURI.contains("/page/error")) {
            return true;
        }else if(!requestURI.contains("/user")){
            System.out.println("拦截=====");
            User existUser = (User) request.getSession().getAttribute("existUser");
            if (existUser == null) {
                response.sendRedirect("/");
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) throws Exception {
        // TODO Auto-generated method stub
        
    }

}
