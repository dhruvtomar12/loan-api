package com.example.loan_api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDate;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ExternalLoanApiResponse {
    private String loanAccountNumber;
    private String accountHolderName;
    private LocalDate dueDate;
    private Integer emiAmount;
    private String status;

    public ExternalLoanApiResponse() {
    }

    public String getLoanAccountNumber() {
        return loanAccountNumber;
    }

    public void setLoanAccountNumber(String loanAccountNumber) {
        this.loanAccountNumber = loanAccountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getEmiAmount() {
        return emiAmount;
    }

    public void setEmiAmount(Integer emiAmount) {
        this.emiAmount = emiAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ExternalLoanApiResponse{" +
                "loanAccountNumber='" + loanAccountNumber + '\'' +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", dueDate=" + dueDate +
                ", emiAmount=" + emiAmount +
                ", status='" + status + '\'' +
                '}';
    }
}
