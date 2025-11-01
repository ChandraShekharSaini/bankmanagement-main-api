package com.sprinboot.bankmanagement2api.service;

import com.sprinboot.bankmanagement2api.exception.AccountDetailsNotFound;
import com.sprinboot.bankmanagement2api.model.AccountTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AccountService {

    List<AccountTO> getAccount() throws AccountDetailsNotFound;
}
