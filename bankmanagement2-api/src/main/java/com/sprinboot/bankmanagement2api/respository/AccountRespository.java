package com.sprinboot.bankmanagement2api.respository;

import com.sprinboot.bankmanagement2api.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRespository extends JpaRepository<Account, Integer> {
}
