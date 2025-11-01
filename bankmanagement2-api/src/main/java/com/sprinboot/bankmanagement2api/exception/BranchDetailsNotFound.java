package com.sprinboot.bankmanagement2api.exception;

public class BranchDetailsNotFound extends Exception {

    public BranchDetailsNotFound(String name) {
        super(name);
    }

    public BranchDetailsNotFound(String name, Throwable cause) {
        super(name, cause);
    }
}
