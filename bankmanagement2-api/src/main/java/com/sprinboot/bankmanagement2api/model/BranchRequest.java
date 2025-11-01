package com.sprinboot.bankmanagement2api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class BranchRequest {

    @NotNull
    String branchName;
    String branchAddress;
}
