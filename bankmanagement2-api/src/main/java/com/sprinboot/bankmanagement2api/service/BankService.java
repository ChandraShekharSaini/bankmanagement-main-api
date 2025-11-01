package com.sprinboot.bankmanagement2api.service;


import com.sprinboot.bankmanagement2api.entity.Bank;
import com.sprinboot.bankmanagement2api.exception.BankDetailsNotFound;
import com.sprinboot.bankmanagement2api.model.BankRequest;
import com.sprinboot.bankmanagement2api.model.BankResponseTO;
import com.sprinboot.bankmanagement2api.model.BankTO;
import com.sprinboot.bankmanagement2api.model.BankUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BankService {

    List<BankTO> getAllBanks() throws BankDetailsNotFound;

    BankTO getBankById(Integer id) throws BankDetailsNotFound;

    String deleteBankById(Integer code) throws BankDetailsNotFound;

    BankTO getByName(String name) throws BankDetailsNotFound;

    BankTO updateBank(BankUpdateRequest bank) throws BankDetailsNotFound;

    BankResponseTO addBank(BankRequest bank) throws BankDetailsNotFound;

    void evictAllCache();;

}