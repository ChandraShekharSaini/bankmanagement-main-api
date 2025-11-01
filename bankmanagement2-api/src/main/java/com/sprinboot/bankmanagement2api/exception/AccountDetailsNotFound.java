package com.sprinboot.bankmanagement2api.exception;

public class AccountDetailsNotFound extends Exception {

    public AccountDetailsNotFound(String name) {
        super(name);
    }

    public AccountDetailsNotFound(String name, Throwable cause) {
        super(name, cause);
    }


}
