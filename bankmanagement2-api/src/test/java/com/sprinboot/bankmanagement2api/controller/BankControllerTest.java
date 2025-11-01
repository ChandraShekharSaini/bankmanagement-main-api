//package com.sprinboot.bankmanagement2api.controller;
//
//import com.sprinboot.bankmanagement2api.entity.Branch;
//import com.sprinboot.bankmanagement2api.exception.BankDetailsNotFound;
//import com.sprinboot.bankmanagement2api.model.BankTO;
//import com.sprinboot.bankmanagement2api.model.BranchTO;
//import com.sprinboot.bankmanagement2api.service.BankService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.bean.override.mockito.MockitoBean;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

//import java.util.Arrays;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith(MockitoExtension.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//public class BankControllerTest {
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @MockitoBean
//    BankService bankService;
//
//    @Test
//    public void getAllBank_whenBanksArePresent_thenReturnBank() throws Exception {
//
//        BranchTO branchTO = new BranchTO(1, "Branch1", "Address1");
//        BankTO bankTO = new BankTO(2, "Bank1", "Address2", Arrays.asList(branchTO));
//
//        when(bankService.getAllBanks()).thenReturn(Arrays.asList(bankTO));
//
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/bank/getBanks").contentType(String.valueOf(MediaType.APPLICATION_JSON));
//
//        mockMvc.perform(requestBuilder).andExpect(status().isOk());
//    }
//
//    @Test
//    public void getAllBank_whenBanksAreNotPresent_thenThrowException() throws Exception {
//
//        when(bankService.getAllBanks()).thenThrow(BankDetailsNotFound.class);
//
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/bank/getBanks").contentType(String.valueOf(MediaType.APPLICATION_JSON));
//
//        mockMvc.perform(requestBuilder).andExpect(status().isNotFound());
//    }
//
//}


package com.sprinboot.bankmanagement2api.controller;

import com.sprinboot.bankmanagement2api.exception.BankDetailsNotFound;
import com.sprinboot.bankmanagement2api.model.*;
import com.sprinboot.bankmanagement2api.service.BankService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.function.ObjDoubleConsumer;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class BankControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    private BankService bankService;

    @Test
    public void getAllBanks_whenBanksArePresent_thenReturnListOfBanks() throws Exception {
        BranchTO branchTO = new BranchTO(1, "Branch1", "Address1");
        BankTO bankTO = new BankTO(2, "Bank2", "Address2", Arrays.asList(branchTO));

        when(bankService.getAllBanks()).thenReturn(Arrays.asList(bankTO));

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/bank")
                .contentType(org.springframework.http.MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().isOk());
    }

    @Test
    public void getAllBanks_whenBankDetailsNotPresent_thenThrowException() throws Exception {
        when(bankService.getAllBanks()).thenThrow(BankDetailsNotFound.class);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/bank")
                .contentType(org.springframework.http.MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder).andExpect(status().isNotFound());
    }

    @Test
    public void getAllBankById_whenBankPresent_thenReturnBank() throws Exception {
        BranchTO branchTO = new BranchTO(1, "Branch1", "Address1");
        BankTO bankTO = new BankTO(2, "Bank2", "Address2", Arrays.asList(branchTO));

        when(bankService.getBankById(anyInt())).thenReturn(bankTO);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/bank/1").contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().isOk());
    }

    @Test
    public void getAllBankById_whenBankDetailsNotPresent_thenThrowException() throws Exception {

        when(bankService.getBankById(anyInt())).thenThrow(BankDetailsNotFound.class);

        RequestBuilder bankRequest = MockMvcRequestBuilders.get("/v1/bank/1").contentType(String.valueOf(MediaType.APPLICATION_JSON));

        mockMvc.perform(bankRequest).andExpect(status().isNotFound());
    }

//    @Test
//    public void addBank_whenValidInput_thenReturnCreated() throws Exception {
//        BankResponseTO responseTO = new BankResponseTO(1, "Bank Data Successfully");
//
//        when(bankService.addBank(any())).thenReturn(responseTO);
//
//        BranchRequest branchRequest = new BranchRequest();
//        branchRequest.setBranchName("Branch1");
//        branchRequest.setBranchAddress("Address3");
//
//
//        BankRequest bankrequest = new BankRequest();
//        bankrequest.setBankName("Bank Name");
//        bankrequest.setBankAddress("Address1");
//        bankrequest.setBranchSet(Arrays.asList(branchRequest));
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String bankResTO = objectMapper.writeValueAsString(responseTO);
//
//        RequestBuilder bankRequest = MockMvcRequestBuilders.post("/v1/bank/addd").contentType(MediaType.APPLICATION_JSON).content(bankResTO).accept(MediaType.APPLICATION_JSON);
//
//        mockMvc.perform(bankRequest).andExpect(status().isCreated());
//    }

    @Test
    public void addBank_whenInValidInput_thenReturnResponse() throws Exception {

        when(bankService.addBank(any())).thenThrow(BankDetailsNotFound.class);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/v1/bank/add").contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder).andExpect(status().isBadRequest());
    }
}