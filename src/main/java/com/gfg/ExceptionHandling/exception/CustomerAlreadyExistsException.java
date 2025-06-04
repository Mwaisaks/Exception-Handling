package com.gfg.ExceptionHandling.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class CustomerAlreadyExistsException extends RuntimeException{

    private String message;

}

// Creating a custom exception that can be thrown when a user tries to add a customer that already exists