package com.sprinboot.bankmanagement2api.exception;

public class LoanDetailsNotFound extends Exception {

    public LoanDetailsNotFound(String name) {
        super(name);
    }

    public LoanDetailsNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
