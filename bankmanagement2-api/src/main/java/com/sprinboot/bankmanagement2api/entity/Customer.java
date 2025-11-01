package com.sprinboot.bankmanagement2api.entity;

import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Cust_ID")
    private Integer custId;

    @Column(name = "Cust_Name")
    private String custName;

    @Column(name = "Cust_Phone")
    private String custPhone;

    @Column(name = "Cust_Address")
    private String custAddress;


    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    Set<Loan> loanset;

}
