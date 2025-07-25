package com.example.loan_api.repo;

import com.example.loan_api.model.LoanAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanAccountRepository extends JpaRepository<LoanAccount,String> {
}
