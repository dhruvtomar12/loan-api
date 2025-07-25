package com.example.loan_api.controller;

import com.example.loan_api.dto.LoanAccountResponseDto;
import com.example.loan_api.service.LoanAccountService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/loanaccount")
public class LoanAccountController {
    private static final Logger log = LoggerFactory.getLogger(LoanAccountController.class);
    @Autowired
    private LoanAccountService service;

    @GetMapping("/{loanAccountNumber}")
    public ResponseEntity<LoanAccountResponseDto> getLoanDetails(@PathVariable String loanAccountNumber){
        log.info("Received request for loan account: {}",loanAccountNumber);
        return ResponseEntity.ok(service.getLoanAccount(loanAccountNumber));
    }
}
