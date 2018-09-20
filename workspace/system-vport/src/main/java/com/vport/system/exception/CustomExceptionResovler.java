package com.vport.system.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 异常处理器
 * @author Administrator
 *
 */
public class CustomExceptionResovler implements HandlerExceptionResolver{

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
            Object handler, Exception ex) {
        //判断异常类型
        ModelAndView modelAndView = new ModelAndView();
        if (ex instanceof MessageException) {
            MessageException messageException = (MessageException) ex;
            System.out.println(messageException.getmString());
            modelAndView.addObject("msg", messageException.getmString());
        }else{
            ex.printStackTrace();
        }
        
        
        modelAndView.setViewName("msg");
        
        return modelAndView;
    }

}
