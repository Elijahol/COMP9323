package com.vport.usermanage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vport.usermanage.pojo.Customer;
import com.vport.usermanage.service.CustomerService;

@Controller
@RequestMapping(value = "customer" )
public class CustomerLoginAndRegistController {
    
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
    private CustomerService customerService;
    
    @RequestMapping(value = "login",method = RequestMethod.POST)
    
    public void login(String email,String password){
        try {
            System.out.println(email+"--"+password);
            Customer customer = customerService.login(email,password);
            response.setContentType("text/html;charset=UTF-8");
            if(customer == null){
                response.getWriter().println("1");
            }else{
                if(!password.equals(customer.getPassword())){
                    response.getWriter().println("2");
                }else if(customer.getStatus() != 0){
                    response.getWriter().println("3");
                }else{
                    session.setAttribute("USE_SESSION", customer);
                    response.getWriter().println("4");
                }
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(Customer customer,Model model){
        boolean flag = customerService.save(customer);
        model.addAttribute("msg", "Congratulation! Please Log into your registered email to active your account!");
        return "msg";
    }
    
    @RequestMapping(value = "checkEmail",method = RequestMethod.POST)
    public String checkEmail(String email,HttpServletRequest request,HttpServletResponse response){
        try {
            List<Customer> list = customerService.queryCustomerByEmail(email);
            if(list.size() != 0){
                // 用户名被占用:
                response.getWriter().println("1");
            }else{
                response.getWriter().println("2");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    //http://localhost/rest/customer/activate
    
    @RequestMapping(value = "activate",method = RequestMethod.GET)
    public String activate(String code,Model model){
        Customer customer = customerService.queryCustomerByCode(code);
        if(customer == null){
            model.addAttribute("msg", "Your activation code is wrong, please sigin again!");
            return "msg";
        }else{
            customer.setStatus(0);
            customer.setCode(null);
            customerService.updateCustomerById(customer);
            model.addAttribute("msg", "You have successfully activated your account, please login!");
            return "msg";
        }
    }
}
