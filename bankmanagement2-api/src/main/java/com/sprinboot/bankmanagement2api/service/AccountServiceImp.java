package com.sprinboot.bankmanagement2api.service;

import com.sprinboot.bankmanagement2api.entity.Account;
import com.sprinboot.bankmanagement2api.exception.AccountDetailsNotFound;
import com.sprinboot.bankmanagement2api.exception.BankDetailsNotFound;
import com.sprinboot.bankmanagement2api.model.AccountTO;
import com.sprinboot.bankmanagement2api.model.BankTO;
import com.sprinboot.bankmanagement2api.respository.AccountRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImp implements AccountService {

    @Autowired
    AccountRespository accountRespository;

    @Override
    public List<AccountTO> getAccount() throws AccountDetailsNotFound {

        List<Account> accountList = accountRespository.findAll();

        if (accountList.isEmpty()) {
            throw new AccountDetailsNotFound("Accoun Not Found");
        }

        return accountList.stream().map(account -> convertToAccountTO(account)).collect(Collectors.toList());
    }



    public AccountTO convertToAccountTO(Account account) {

        return new AccountTO(
                account.getAccountNumber(),
                account.getAccountType(),
                account.getAccountBalance()

        );
    }

}
