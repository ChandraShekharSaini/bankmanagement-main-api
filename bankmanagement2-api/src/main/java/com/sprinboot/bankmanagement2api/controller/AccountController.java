package com.sprinboot.bankmanagement2api.controller;

import com.sprinboot.bankmanagement2api.entity.Account;
import com.sprinboot.bankmanagement2api.exception.AccountDetailsNotFound;
import com.sprinboot.bankmanagement2api.exception.BankDetailsNotFound;
import com.sprinboot.bankmanagement2api.model.AccountTO;
import com.sprinboot.bankmanagement2api.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v2/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/getAllAccounts")
    public ResponseEntity<List<AccountTO>> getAllAccount() throws Exception {

        log.info(".........Fetching Account Details..............");
        List<AccountTO> accontList;
        accontList = accountService.getAccount();
        return new ResponseEntity<>(accontList, HttpStatus.OK);

    }
}
