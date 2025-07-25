package com.example.loan_api.service;

import com.example.loan_api.dto.LoanAccountResponseDto;
import com.example.loan_api.integration.ExternalLoanApiClient;
import com.example.loan_api.model.LoanAccount;
import com.example.loan_api.repo.LoanAccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class LoanAccountService {
    private static final Logger log = LoggerFactory.getLogger(LoanAccountService.class);
    @Autowired
    private ExternalLoanApiClient externalLoanApiClient;

    @Autowired
    private LoanAccountRepository loanAccountRepository;

//    private final RestTemplate restTemplate;
//    public LoanAccountService(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }

    public LoanAccountResponseDto getLoanAccount(String loanAccountNumber){
        log.info("Fetching loan account: {}",loanAccountNumber);
        LoanAccount loan=externalLoanApiClient.fetchLoanAccount(loanAccountNumber);
        loanAccountRepository.save(loan);
        return new LoanAccountResponseDto(loan.getLoanAccountNumber(),loan.getDueDate(),loan.getEmiAmount());
    }
}
