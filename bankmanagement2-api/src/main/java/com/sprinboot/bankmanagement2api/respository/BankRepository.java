package com.sprinboot.bankmanagement2api.respository;


import com.sprinboot.bankmanagement2api.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank, Integer> {

    Bank findByBankName(String name);


}
