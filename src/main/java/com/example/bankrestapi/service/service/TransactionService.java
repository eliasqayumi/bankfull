package com.example.bankrestapi.service.service;

import com.example.bankrestapi.model.Transaction;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionService {
    void createTransaction(Transaction transaction);

    void deleteTransaction(Long transactionId);

    Transaction updateTransaction(Long transactionId, Transaction transaction);

    Transaction findByTransactionId(Long transactionId);

    List<Transaction> findAllTransactionByAccountId(Long accountId);

    List<Transaction> findAllTransactionByDate(LocalDateTime localDateTime);

    List<Transaction> findAllTransactionByBeneficiary(String beneficiary);

    List<Transaction> findAllTransaction();

}
