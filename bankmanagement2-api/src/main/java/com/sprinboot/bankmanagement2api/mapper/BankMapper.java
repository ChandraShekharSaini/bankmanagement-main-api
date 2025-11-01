package com.sprinboot.bankmanagement2api.mapper;

import com.sprinboot.bankmanagement2api.entity.Bank;
import com.sprinboot.bankmanagement2api.entity.Branch;
import com.sprinboot.bankmanagement2api.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class BankMapper {

    public static BankTO convertBankT0(Bank bank) {

        List<BranchTO> branchToList = bank.getBranchSet() != null ? bank.getBranchSet().stream().map(
                branch -> new BranchTO(
                        branch.getBranchCode(),
                        branch.getBranchName(),
                        branch.getBranchAddress()
                )
        ).collect(Collectors.toList()) : List.of();

        return new BankTO(
                bank.getBankCode(),
                bank.getBankName(),
                bank.getBankAddress(),
                branchToList

        );

    }


    public static Bank convertRequestToBankEntity(BankRequest bankRequest) {

        Bank bank = new Bank();
        bank.setBankName(bankRequest.getBankName());
        bank.setBankAddress(bankRequest.getBankAddress());

        if (!CollectionUtils.isEmpty(bankRequest.getBranchSet())) {

            Set<Branch> branchSet = bankRequest.getBranchSet().stream().map((branchRequest) -> {
                Branch branch = new Branch();
                branch.setBranchName(branchRequest.getBranchName());
                branch.setBranchAddress(branchRequest.getBranchAddress());
                branch.setBank(bank);
                return branch;
            }).collect(Collectors.toSet());

            bank.setBranchSet(branchSet);
        }

        return bank;
    }


    public static BankResponseTO convertToBankResponse(Bank savedBank) {
        BankResponseTO bakResponse = new BankResponseTO(savedBank.getBankCode(), "Bank is Saved Successfully");

        return bakResponse;
    }


    public static Bank convertToUpdateBankEntity(BankUpdateRequest bankRequest) {
        Bank bank = new Bank();
        bank.setBankCode(bankRequest.getBankCode());
        bank.setBankName(bankRequest.getBankName());
        bank.setBankAddress(bankRequest.getBankAddress());

        if (!CollectionUtils.isEmpty(bankRequest.getBranchList())) {

            Set<Branch> brachList = bankRequest.getBranchList().stream().map((branchRequest) -> {
                Branch branch = new Branch();
                log.info("...branch..",branchRequest.getBranchCode());
                branch.setBranchCode(branchRequest.getBranchCode());
                branch.setBranchName(branchRequest.getBranchName());
                branch.setBranchAddress(branchRequest.getBranchAddress());
                branch.setBank(bank);
                return branch;
            }).collect(Collectors.toSet());

            bank.setBranchSet(brachList);
        }

        return bank;
    }
}
