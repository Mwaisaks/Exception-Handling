package com.gfg.ExceptionHandling.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class NoSuchCustomerExistsException extends RuntimeException{

    private String message;

}
