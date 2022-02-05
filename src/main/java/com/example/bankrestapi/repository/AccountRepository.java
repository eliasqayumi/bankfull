package com.example.bankrestapi.repository;

import com.example.bankrestapi.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    Optional<Account> findByAccountId(Long accountId);
    Optional<Account> findByCustomerId(Long accountId);
    Optional<Account> findByAccountNumber(Long accountId);
}
