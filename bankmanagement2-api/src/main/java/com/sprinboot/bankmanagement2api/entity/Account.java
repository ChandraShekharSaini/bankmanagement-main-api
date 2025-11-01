package com.sprinboot.bankmanagement2api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "t_account")
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Account_Number")
    private Integer accountNumber;


    @Column(name = "Account_Type")
    private String accountType;

    @Column(name = "Account_Balance")
    private double accountBalance;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "branchId", referencedColumnName = "Branch_Code")
    private Branch branch;
}

