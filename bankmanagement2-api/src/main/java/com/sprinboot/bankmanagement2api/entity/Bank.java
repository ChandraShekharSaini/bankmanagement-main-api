package com.sprinboot.bankmanagement2api.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "t_BANK")
@Getter
@Setter
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Bank_Code")
    private Integer bankCode;

    @Column(name = "Bank_Name")
    private String bankName;

    @Column(name = "Bank_Address")
    private String bankAddress;

    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Branch> branchSet;
}
