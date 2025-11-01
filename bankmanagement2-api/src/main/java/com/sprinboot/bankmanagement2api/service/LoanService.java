package com.sprinboot.bankmanagement2api.service;

import com.sprinboot.bankmanagement2api.respository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService implements LoanServiceImp {

    @Autowired
    LoanRepository loanRepository;
}
