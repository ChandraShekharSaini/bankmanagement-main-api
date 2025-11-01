package com.sprinboot.bankmanagement2api.exception;

public class BankDetailsNotFound extends Exception {

    public BankDetailsNotFound(String message) {
        super(message);
    }

    public BankDetailsNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
