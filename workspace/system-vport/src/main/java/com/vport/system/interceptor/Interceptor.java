package com.vport.system.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.vport.system.pojo.person.User;
/**
 * This is an interceptor which is the entrance
 * of the whole system. All requests from front end
 * must be handled firstly by this interceptor.
 * If the reuqest is to request the page that does not require
 * the user to login first, the interceptor will pass the request
 * to the relevant controller.
 * Otherwise, the interceptor will validate if the user has logined.
 * @author Siyu Wang
 *
 */
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
            System.out.println("intercept=====");
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
        
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) throws Exception {
        
    }

}
