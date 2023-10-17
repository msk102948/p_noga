package com.p_noga.p_noga.repository;

import com.p_noga.p_noga.entity.FinancialTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancailTransactionRepository extends JpaRepository<FinancialTransaction, String> {
}
