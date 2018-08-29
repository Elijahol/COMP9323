package com.vport.system.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vport.system.bean.PlanTree;
import com.vport.system.pojo.User;
import com.vport.system.service.PlanService;
import com.vport.system.service.UserService;
import com.vport.system.utils.MailUtils;

/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/application*.xml")*/
public class Demo {
    @Autowired
    private UserService userService;
    
    @Autowired
    private PlanService planService;
    
    
    @Autowired
    private MailUtils mailUtils;
    @Test
    public void fun3(){
       
        PlanTree planTree = planService.getPlanTree();
        System.out.println(1);
    }
    
    @Test
    public void fun1(){
        User user = new User();
        user.setEmail("20432707@qq.com");
        user.setPassword("123");
        User u2 = userService.findByEmailandPassword(user);
        System.out.println(u2);
    }
    
    @Test
    public void fun2(){
      
        System.out.println("123");
           User user = new User();
           user.setName("李思宇");
           user.setPassword("123");
           user.setEmail("20432707@qq.com");
           user.setPhone("123");
           try {
           userService.register(user);
           } catch (Exception e1) {
//             e1.printStackTrace();
             System.out.println(e1.getMessage());
         }
           System.out.println("456");
    
       try {
           Thread.sleep(30 * 1000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
    }
    
}
