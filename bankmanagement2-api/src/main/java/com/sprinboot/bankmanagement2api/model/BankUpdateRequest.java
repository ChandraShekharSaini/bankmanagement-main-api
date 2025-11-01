package com.sprinboot.bankmanagement2api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class BankUpdateRequest {

    private Integer bankCode;
    private String bankName;
    private String bankAddress;
    private List<BranchUpdateRequest> branchList;
}
