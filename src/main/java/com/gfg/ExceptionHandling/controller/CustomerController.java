package com.gfg.ExceptionHandling.controller;

import com.gfg.ExceptionHandling.exception.CustomerAlreadyExistsException;
import com.gfg.ExceptionHandling.exception.NoSuchCustomerExistsException;
import com.gfg.ExceptionHandling.model.Customer;
import com.gfg.ExceptionHandling.model.dtos.ErrorResponse;
import com.gfg.ExceptionHandling.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    @GetMapping
    public String home(){
        return "This project was done to explore exception handling in Spring Boot";
    }

    @GetMapping("/getCustomer/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id){
        Customer customer = customerService.getCustomer(id);

        return ResponseEntity.ok(customer);
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<String> addCustomer(@Valid @RequestBody Customer customer){
        String addedCustomer = customerService.addCustomer(customer);

        return new ResponseEntity<>(addedCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<String> updateCustomer(@Valid @RequestBody Customer customer){
        String updatedCustomer = customerService.updateCustomer(customer);

        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    @ExceptionHandler(value = NoSuchCustomerExistsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNoSuchCustomerExistsException(NoSuchCustomerExistsException ex) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNoSuchElementException(NoSuchElementException ex) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleCustomerAlreadyExistsException(CustomerAlreadyExistsException exception){
        return new ErrorResponse(HttpStatus.CONFLICT.value(), exception.getMessage());
    }

}
