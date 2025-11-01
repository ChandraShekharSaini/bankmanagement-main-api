package com.sprinboot.bankmanagement2api.controller;


import com.sprinboot.bankmanagement2api.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;
}
