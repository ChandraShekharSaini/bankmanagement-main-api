package com.sprinboot.bankmanagement2api.controller;

import com.sprinboot.bankmanagement2api.entity.Bank;
import com.sprinboot.bankmanagement2api.exception.BankDetailsNotFound;
import com.sprinboot.bankmanagement2api.model.BankRequest;
import com.sprinboot.bankmanagement2api.model.BankResponseTO;
import com.sprinboot.bankmanagement2api.model.BankTO;
import com.sprinboot.bankmanagement2api.model.BankUpdateRequest;
import com.sprinboot.bankmanagement2api.service.BankService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/banks")
public class BankController {

    @Autowired
    BankService bankService;


    @PostMapping("/add")
    public ResponseEntity<BankResponseTO> addBank(@RequestBody BankRequest bank) throws BankDetailsNotFound {
        log.info("............Adding Bank...............");
        BankResponseTO bankResponse = bankService.addBank(bank);

        return new ResponseEntity<>(bankResponse, HttpStatus.CREATED);
    }

    @GetMapping("/getBanks")
    public ResponseEntity<List<BankTO>> getAllBanks() throws BankDetailsNotFound {
        log.info("........Fetch All Banks...................");

        List<BankTO> bankList = bankService.getAllBanks();
        return new ResponseEntity<>(bankList, HttpStatus.OK);

//        try {
//            bankList = bankService.getAllBanks();
//            return new ResponseEntity<>(bankList, HttpStatus.OK);
//        } catch (BankDetailsNotFound e) {
//            log.info("Bank Details not found {}", e.getMessage());
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        } catch (Exception e) {
//            log.info("Internal Server Error {}", e.getMessage());
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
    }

    @GetMapping("/{code}")
    public ResponseEntity<BankTO> getBankById(@PathVariable("code") @Positive(message = "ID Must Be Positive Number") int code) throws BankDetailsNotFound {

        log.info("................Fetching Bank Details............................");
        BankTO bankList = bankService.getBankById(code);
        return new ResponseEntity<>(bankList, HttpStatus.OK);

//        try {
//            bankList = bankService.getAllBankById(code);
//            return new ResponseEntity<>(bankList, HttpStatus.OK);
//        } catch (BankDetailsNotFound e) {
//            log.info("Bank Details not found {}", e.getMessage());
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        } catch (Exception e) {
//            log.info("Internal Server Error {}", e.getMessage());
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
    }

    @DeleteMapping("/delete")
    public String deleteBankById(@RequestParam("code") @Positive(message = "ID Must Be Positive Number") Integer code) throws BankDetailsNotFound {

        log.info("....................Delte BY ID....................");
        String msg = bankService.deleteBankById(code);
        log.info(".......Data Deleted Successfully.........");
        return msg;
    }

    @GetMapping("/getByName")
    public ResponseEntity<BankTO> getBankByName(@RequestParam("name") String name) throws BankDetailsNotFound {
        BankTO bankTO = bankService.getByName(name);

        return new ResponseEntity<>(bankTO, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<BankTO> updateBank(@RequestBody @Valid BankUpdateRequest bank) throws BankDetailsNotFound {
        log.info(".............Updating Details...............{}", bank);
        BankTO updatedBank = bankService.updateBank(bank);

        return new ResponseEntity<>(updatedBank, HttpStatus.OK);
    }


    @GetMapping("/clearCache")
    public ResponseEntity<String> clearAllCahche() {

        log.info("Deleting Cache..............");
        bankService.evictAllCache();

        return new ResponseEntity<>("Cache Clear Successfully", HttpStatus.OK);
    }
}
