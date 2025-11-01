package com.sprinboot.bankmanagement2api.exception;

public class CustomerDetailsNotFound extends Exception {

    public CustomerDetailsNotFound(String message) {
        super(message);
    }


    public CustomerDetailsNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
