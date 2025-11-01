package com.sprinboot.bankmanagement2api.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "t_branch")
@Getter
@Setter

public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Branch_Code")
    private Integer branchCode;

    @Column(name = "Branch_Name")
    private String branchName;

    @Column(name = "Branch_Address")
    private String branchAddress;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Bank_Code", referencedColumnName = "Bank_Code" , nullable = false)
    private Bank bank;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<Loan> loanSet;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Account> accountSet;

}
