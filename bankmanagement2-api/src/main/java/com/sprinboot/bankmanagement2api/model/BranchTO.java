package com.sprinboot.bankmanagement2api.model;

import jakarta.persistence.Column;
import lombok.*;


public record BranchTO(
        Integer branchCode,
        String branchName,
        String branchAddress
) {
}
