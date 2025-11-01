package com.sprinboot.bankmanagement2api.model;




public record AccountTO(
        Integer accountNumber,
        String accountType,
        double accountBalance
) {



}
