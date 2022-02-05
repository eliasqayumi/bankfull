package com.example.bankrestapi.repository;

import com.example.bankrestapi.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.lang.management.OperatingSystemMXBean;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllByAccountId(Long accountId);
    List<Transaction> findAllByTransactionDate(LocalDateTime transactionDate);
    List<Transaction> findAllByBeneficiary(String beneficiary);

}
