package com.example.bankrestapi.service.service;

import com.example.bankrestapi.model.Account;
import java.util.List;

public interface AccountService {
    void createAccount(Account account);
    void deleteAccount(Long accountId);
    Account updateAccount(Long accountId,Account account);
    List<Account> findAllAccount();
    Account findByAccountId(Long accountId);
    Account findByCustomerId(Long customerId);
    Account findByAccountNumber(Long accountNumber);
}
