package com.sprinboot.bankmanagement2api.respository;


import com.sprinboot.bankmanagement2api.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {
}
