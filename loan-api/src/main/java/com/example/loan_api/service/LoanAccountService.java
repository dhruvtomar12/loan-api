package com.example.loan_api.service;

import com.example.loan_api.dto.ExternalLoanApiResponse;
import com.example.loan_api.dto.LoanAccountResponseDto;
import com.example.loan_api.model.LoanAccount;
import com.example.loan_api.integration.ExternalLoanApiClient;
import com.example.loan_api.repo.LoanAccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoanAccountService {

    private static final Logger log = LoggerFactory.getLogger(LoanAccountService.class);

    private final ExternalLoanApiClient externalClient;
    private final LoanAccountRepository loanRepository;

    public LoanAccountService(ExternalLoanApiClient externalClient, LoanAccountRepository loanRepository) {
        this.externalClient = externalClient;
        this.loanRepository = loanRepository;
    }

    @Transactional
    public LoanAccountResponseDto getAndPersistLoanDetails(String loanAccountNumber) {
        ExternalLoanApiResponse externalData = externalClient.fetchLoanDetails(loanAccountNumber);

        LoanAccount savedAccount = saveOrUpdateLoanAccount(externalData);
        return new LoanAccountResponseDto(
                savedAccount.getLoanAccountNumber(),
                savedAccount.getDueDate(),
                savedAccount.getEmiAmount()
        );
    }

    private LoanAccount saveOrUpdateLoanAccount(ExternalLoanApiResponse externalData) {
        if (loanRepository.existsByLoanAccountNumber(externalData.getLoanAccountNumber())) {
            log.warn("Loan account {} already exists. It will be updated.", externalData.getLoanAccountNumber());
        }
        LoanAccount loanAccount = new LoanAccount();
        loanAccount.setLoanAccountNumber(externalData.getLoanAccountNumber());
        loanAccount.setDueDate(externalData.getDueDate());
        loanAccount.setEmiAmount(externalData.getEmiAmount());
        log.info("Saving loan account {} to the database.", loanAccount.getLoanAccountNumber());
        LoanAccount savedEntity = loanRepository.save(loanAccount);
        log.info("Loan account {} saved successfully with ID: {}", savedEntity.getLoanAccountNumber(), savedEntity.getId());

        return savedEntity;
    }
}