package com.gfg.ExceptionHandling.service;

import com.gfg.ExceptionHandling.model.Customer;

public interface CustomerService {

    Customer getCustomer(Long id);

    String addCustomer(Customer customer);

    String updateCustomer(Customer customer);
}
