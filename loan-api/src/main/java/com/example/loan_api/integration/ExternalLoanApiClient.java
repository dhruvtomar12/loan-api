package com.example.loan_api.integration;

import com.example.loan_api.Exception.ExternalApiException;
import com.example.loan_api.controller.LoanAccountController;
import com.example.loan_api.model.LoanAccount;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class ExternalLoanApiClient {
    private static final Logger log = LoggerFactory.getLogger(ExternalLoanApiClient.class);
    private final RestTemplate restTemplate=new RestTemplate();

    public LoanAccount fetchLoanAccount(String loanAccountNumber){
        String url="http://demo9993930.mockable.io/loanaccount/"+loanAccountNumber;
        try{
            log.info("Calling external API: {}",url);
            return restTemplate.getForObject(url,LoanAccount.class);
        } catch (RestClientException e){
            log.error("Error calling external API",e);
            throw new ExternalApiException("Failed to fetch loan account from external API");
        }
    }
}
