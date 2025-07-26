package com.example.loan_api.controller;

import com.example.loan_api.dto.LoanAccountResponseDto;
import com.example.loan_api.Exception.ResourceNotFoundException;
import com.example.loan_api.service.LoanAccountService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/loan-accounts")
public class LoanAccountController {

    private final LoanAccountService loanService;

    public LoanAccountController(LoanAccountService loanService) {
        this.loanService = loanService;
    }

    @GetMapping("/{loanAccountNumber}")
    public ResponseEntity<LoanAccountResponseDto> getLoanDetails(@PathVariable String loanAccountNumber) {
        LoanAccountResponseDto response = loanService.getAndPersistLoanDetails(loanAccountNumber);
        return ResponseEntity.ok(response);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}