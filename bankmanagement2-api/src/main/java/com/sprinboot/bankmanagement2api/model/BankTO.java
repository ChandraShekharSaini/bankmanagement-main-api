package com.sprinboot.bankmanagement2api.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


public record BankTO(
        Integer bankCode,
        String bankName,
        String bankAddress,
        List<BranchTO> branchToList
) {
}
