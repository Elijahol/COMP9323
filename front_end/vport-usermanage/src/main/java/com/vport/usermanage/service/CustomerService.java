package com.vport.usermanage.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.abel533.entity.Example;
import com.vport.usermanage.mapper.CustomerMapper;
import com.vport.usermanage.pojo.Customer;
import com.vport.usermanage.utils.MailUtils;
import com.vport.usermanage.utils.UUIDUtils;


@Service
public class CustomerService{
    
    @Autowired
    private CustomerMapper customerMapper;


    public boolean save(Customer customer) {
        customer.setStatus(1);//未激活
        String code = UUIDUtils.getUUID()+UUIDUtils.getUUID();
        customer.setCode(code);
        try {
            MailUtils.sendMail(customer.getEmail(), customer.getUsername(), code);
            return customerMapper.insert(customer) == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }


    public List<Customer> queryCustomerByEmail(String email) {
        Example example = new Example(Customer.class);
        example.createCriteria().andEqualTo("email", email);
                
        List<Customer> list = customerMapper.selectByExample(example);
        return list;
    }


    public Customer queryCustomerByCode(String code) {
        Example example = new Example(Customer.class);
        example.createCriteria().andEqualTo("code", code);
        return customerMapper.selectByExample(example).get(0);
        
    }


    public void updateCustomerById(Customer customer) {
        customerMapper.updateByPrimaryKey(customer);
        
    }


    public Customer login(String email, String password) {
        return customerMapper.findCustomerByEmail(email);
        
    }


   
   
    
}
