package com.xbank.txnapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xbank.txnapi.model.db.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByAccountNumber(String accountNumber);

}
