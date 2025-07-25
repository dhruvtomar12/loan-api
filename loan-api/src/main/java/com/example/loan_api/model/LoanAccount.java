package com.example.loan_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class LoanAccount {
    @Id
    private String loanAccountNumber;
    private LocalDate dueDate;
    private Double emiAmount;
    public String getLoanAccountNumber() { return loanAccountNumber; }
    public LocalDate getDueDate() { return dueDate; }
    public Double getEmiAmount() { return emiAmount; }
}
