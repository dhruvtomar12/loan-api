package com.example.loan_api.dto;

import java.time.LocalDate;


public class LoanAccountResponseDto {
    private String loanAccountNumber;
    private LocalDate dueDate;
    private Double emiAmount;

    public LoanAccountResponseDto() {}

    public LoanAccountResponseDto(String loanAccountNumber, LocalDate dueDate, Double emiAmount) {
        this.loanAccountNumber = loanAccountNumber;
        this.dueDate = dueDate;
        this.emiAmount = emiAmount;
    }

    // Getters
    public String getLoanAccountNumber() { return loanAccountNumber; }
    public LocalDate getDueDate() { return dueDate; }
    public Double getEmiAmount() { return emiAmount; }

    public void setLoanAccountNumber(String loanAccountNumber) { this.loanAccountNumber = loanAccountNumber; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }
    public void setEmiAmount(Double emiAmount) { this.emiAmount = emiAmount; }
}
