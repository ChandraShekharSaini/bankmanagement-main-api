package com.sprinboot.bankmanagement2api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class BranchUpdateRequest {

    private Integer branchCode;
    private String branchName;
    private String branchAddress;
}
