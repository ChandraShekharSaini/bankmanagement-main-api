package com.sprinboot.bankmanagement2api.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Entity
@Table(name = "t_loan")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Loan_ID")
    private Integer loanId;

    @Column(name = "Loan_Type")
    private String loanType;

    @Column(name = "Loan_Amount")
    private double loanAmount;

    // Many loans belong to one branch
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Branch_ID", referencedColumnName = "Branch_Code")
    private Branch branch;

    // Many loans belong to one customer
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Cust_ID", referencedColumnName = "Cust_ID")
    private Customer customer;
}
