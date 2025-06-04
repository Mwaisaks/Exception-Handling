package com.gfg.ExceptionHandling.service;

import com.gfg.ExceptionHandling.exception.CustomerAlreadyExistsException;
import com.gfg.ExceptionHandling.exception.NoSuchCustomerExistsException;
import com.gfg.ExceptionHandling.model.Customer;
import com.gfg.ExceptionHandling.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    @Override
    public Customer getCustomer(Long id) {

        return customerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No Customer Present With ID = " + id));
    }

    @Override
    public String addCustomer(Customer customer) {
        Optional<Customer> existingCustomer = customerRepository.findById(customer.getId());

        if(!existingCustomer.isPresent()){
            customerRepository.save(customer);
            return "Customer added successfully!";
        }
        else
            throw new CustomerAlreadyExistsException("Customer Already Exists!!");
    }

    @Override
    public String updateCustomer(Customer customer) {

        Optional<Customer> existingCustomer = customerRepository.findById(customer.getId());

        if (!existingCustomer.isPresent()){
            throw new NoSuchCustomerExistsException("No such customer exists!");
        }
        else {
            existingCustomer.get().setName(customer.getName());
            existingCustomer.get().setAddress(customer.getAddress());
            customerRepository.save(existingCustomer.get());
            return "Record updated successfully!";
        }
    }
}
