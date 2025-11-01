package com.sprinboot.bankmanagement2api.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class BankRequest {

    @NotNull
    private String bankName;
    private String bankAddress;
    private Set<BranchRequest> branchSet;
}
