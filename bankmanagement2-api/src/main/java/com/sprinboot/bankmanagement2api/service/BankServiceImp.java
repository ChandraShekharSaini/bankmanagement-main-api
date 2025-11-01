package com.sprinboot.bankmanagement2api.service;

import com.sprinboot.bankmanagement2api.entity.Bank;
import com.sprinboot.bankmanagement2api.exception.BankDetailsNotFound;
import com.sprinboot.bankmanagement2api.mapper.BankMapper;
import com.sprinboot.bankmanagement2api.model.BankRequest;
import com.sprinboot.bankmanagement2api.model.BankResponseTO;
import com.sprinboot.bankmanagement2api.model.BankTO;
import com.sprinboot.bankmanagement2api.model.BankUpdateRequest;
import com.sprinboot.bankmanagement2api.respository.BankRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BankServiceImp implements BankService {

    @Autowired
    BankRepository bankRepository;


    @Override
    public BankResponseTO addBank(BankRequest bankRequest) throws BankDetailsNotFound {

        Bank bank = BankMapper.convertRequestToBankEntity(bankRequest);

        Bank savedBank = bankRepository.save(bank);

        return BankMapper.convertToBankResponse(savedBank);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public List<BankTO> getAllBanks() throws BankDetailsNotFound {
        log.info("getAllBanks");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.info("Error: {}", e.getMessage());
        }

        List<Bank> banklist = bankRepository.findAll();


        if (banklist.isEmpty()) {
            throw new BankDetailsNotFound("Bank NOT FOUND");
        }

        return banklist.stream().map(bank -> BankMapper.convertBankT0(bank)).collect(Collectors.toList());
    }


    @Cacheable(cacheNames = "banks", key = "#id")
    @Override
    public BankTO getBankById(Integer id) throws BankDetailsNotFound {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.info("Error: {}", e.getMessage());
        }


        Bank bank = bankRepository.findById(id).orElseThrow(() -> {

            return new BankDetailsNotFound("Bank Not Found");
        });

        return BankMapper.convertBankT0(bank);
    }


    public String deleteBankById(Integer code) throws BankDetailsNotFound {

        bankRepository.deleteById(code);

        return "Deleted Successfully";
    }


    @Override
    public BankTO getByName(String name) throws BankDetailsNotFound {

        log.info("getByName");

        Bank bank = bankRepository.findByBankName(name);

        if (bank == null) {
            throw new BankDetailsNotFound("Bank details not found for name: " + name);
        }

        log.info("fetched");
        log.info("Bank  {}", bank);
        return BankMapper.convertBankT0(bank);
    }

    public BankTO updateBank(BankUpdateRequest bankRequest) throws BankDetailsNotFound {

        log.info("...............Updating Details................");

        Bank bank = BankMapper.convertToUpdateBankEntity(bankRequest);

        log.info("...Bnak...", bank.getBankAddress());


        Bank updatedBank = bankRepository.save(bank);

        return BankMapper.convertBankT0(updatedBank);
    }


    @CacheEvict(value = "banks", allEntries = true)
    @Override
    public void evictAllCache() {
        log.info(".........Clear All Cache.........");
    }

}
