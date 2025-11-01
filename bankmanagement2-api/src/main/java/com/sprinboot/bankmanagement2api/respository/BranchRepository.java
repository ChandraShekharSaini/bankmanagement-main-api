package com.sprinboot.bankmanagement2api.respository;

import com.sprinboot.bankmanagement2api.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer> {
}
