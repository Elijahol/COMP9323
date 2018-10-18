package com.vport.system.exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

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
        System.out.println("error: " + ex.getMessage());
        File file = new File("E://comp9323_pro/error/", "msg.txt");
        PrintWriter s = null;
        try {
            s = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ex.printStackTrace(s);
        s.flush();
        s.close();
        modelAndView.setViewName("error");
        
        return modelAndView;
    }

}
