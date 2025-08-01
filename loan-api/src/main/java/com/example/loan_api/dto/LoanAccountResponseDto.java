package com.example.loan_api.dto;

import java.time.LocalDate;

public class LoanAccountResponseDto {

    private String loanAccountNumber;
    private LocalDate dueDate;
    private Integer emiAmount;

    public LoanAccountResponseDto(String loanAccountNumber, LocalDate dueDate, Integer emiAmount) {
        this.loanAccountNumber = loanAccountNumber;
        this.dueDate = dueDate;
        this.emiAmount = emiAmount;
    }

    public String getLoanAccountNumber() {
        return loanAccountNumber;
    }

    public void setLoanAccountNumber(String loanAccountNumber) {
        this.loanAccountNumber = loanAccountNumber;
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

    @Override
    public String toString() {
        return "LoanAccountResponseDto{" +
                "loanAccountNumber='" + loanAccountNumber + '\'' +
                ", dueDate=" + dueDate +
                ", emiAmount=" + emiAmount +
                '}';
    }
}
