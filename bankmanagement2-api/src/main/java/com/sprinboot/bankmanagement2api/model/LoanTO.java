package com.sprinboot.bankmanagement2api.model;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class LoanTO {
    private Integer loanId;

    private String loanType;

    private double loanAmount;

}
