package com.sprinboot.bankmanagement2api.service;

import com.sprinboot.bankmanagement2api.respository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BranchServiceImp implements BranchService {

    @Autowired
    BranchRepository branchRepository;

}
