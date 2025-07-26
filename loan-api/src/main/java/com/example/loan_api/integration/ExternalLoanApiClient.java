package com.example.loan_api.integration;

import com.example.loan_api.dto.ExternalLoanApiResponse;
import com.example.loan_api.Exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class ExternalLoanApiClient {

    private static final Logger log = LoggerFactory.getLogger(ExternalLoanApiClient.class);
    private final RestTemplate restTemplate;
    public ExternalLoanApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    private static final String EXTERNAL_API_BASE_URL = "https://demo9993930.mockable.io/loanaccount/";

    public ExternalLoanApiResponse fetchLoanDetails(String loanAccountNumber) {
        String url = EXTERNAL_API_BASE_URL + loanAccountNumber;
        log.info("Calling external API: {}", url);

        try {
            ExternalLoanApiResponse response = restTemplate.getForObject(url, ExternalLoanApiResponse.class);
            log.info("Successfully received response from external API for account: {}", loanAccountNumber);
            return response;
        } catch (HttpClientErrorException.NotFound ex) {
            log.error("External API returned 404 Not Found for account: {}", loanAccountNumber);
            throw new ResourceNotFoundException("Loan account not found from external service: " + loanAccountNumber);
        } catch (Exception ex) {
            log.error("Error calling external API for account: {}", loanAccountNumber, ex);
            throw new RuntimeException("An error occurred while calling the external loan service.", ex);
        }
    }
}