package com.example.bankrestapi.service.serviceImp;

import com.example.bankrestapi.exception.NotFoundException;
import com.example.bankrestapi.model.AccountType;
import com.example.bankrestapi.repository.AccountTypeRepository;
import com.example.bankrestapi.service.service.AccountTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountTypeServiceImp implements AccountTypeService {
    private AccountTypeRepository accountTypeRepository;

    public AccountTypeServiceImp(AccountTypeRepository accountTypeRepository) {
        this.accountTypeRepository = accountTypeRepository;
    }

    @Override
    public void createAccountType(AccountType accountType) {
        this.accountTypeRepository.save(accountType);
    }

    @Override
    public void deleteAccountTypeId(Long accountTypeId) {
        this.accountTypeRepository.deleteById(accountTypeId);
    }

    @Override
    public AccountType updateAccountType(Long accountTypeId,AccountType accountType) {
        AccountType updateAccountType= this.accountTypeRepository.findById(accountTypeId).orElseThrow();
        updateAccountType.setAccountType(accountType.getAccountType());
        return this.accountTypeRepository.save(accountType);
    }

    @Override
    public AccountType findByAccountTypeId(Long accountTypeId) {
        return this.accountTypeRepository.findById(accountTypeId).orElseThrow(() ->
                new NotFoundException("Account type by account " + accountTypeId + " type id was not found."));
    }

    @Override
    public List<AccountType> findAllAccountType() {
        return this.accountTypeRepository.findAll();
    }
}
