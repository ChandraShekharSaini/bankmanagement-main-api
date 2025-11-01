package com.sprinboot.bankmanagement2api.respository;

import com.sprinboot.bankmanagement2api.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
