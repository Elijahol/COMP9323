package com.vport.usermanage.mapper;

import com.github.abel533.mapper.Mapper;
import com.vport.usermanage.pojo.Customer;

public interface CustomerMapper extends Mapper<Customer>{

    Customer findCustomerByEmail(String email);

}
