package com.example.bankrestapi.Controller;

import com.example.bankrestapi.model.Account;
import com.example.bankrestapi.model.AccountType;
import com.example.bankrestapi.model.Customer;
import com.example.bankrestapi.model.Transaction;
import com.example.bankrestapi.service.serviceImp.AccountServiceImp;
import com.example.bankrestapi.service.serviceImp.AccountTypeServiceImp;
import com.example.bankrestapi.service.serviceImp.CustomerServiceImp;
import com.example.bankrestapi.service.serviceImp.TransactionServiceImp;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    private AccountServiceImp accountServiceImp;
    private AccountTypeServiceImp accountTypeServiceImp;
    private CustomerServiceImp customerServiceImp;
    private TransactionServiceImp transactionServiceImp;

    public AccountController(AccountServiceImp accountServiceImp,TransactionServiceImp transactionServiceImp,
                             AccountTypeServiceImp accountTypeServiceImp,CustomerServiceImp customerServiceImp) {
        this.accountServiceImp = accountServiceImp;
        this.accountTypeServiceImp=accountTypeServiceImp;
        this.customerServiceImp=customerServiceImp;
        this.transactionServiceImp=transactionServiceImp;
        AccountType accountType=new AccountType(1L,"USD");
        this.accountTypeServiceImp.createAccountType(accountType);
        Customer customer=new Customer(1L,"Elias","Qayumi","elyasqayumi@gmail.com","05551415484");
        this.customerServiceImp.createCustomer(customer);
        Account account=new Account(1L,customer,accountType,124523L,23424L);
        this.accountServiceImp.createAccount(account);
        LocalDateTime localDateTime=LocalDateTime.now();
        Transaction transaction=new Transaction(1L,account,500L,localDateTime,"Hamid get","For Home");
        this.transactionServiceImp.createTransaction(transaction);
    }

    @GetMapping("/")
    public List<Account> getAllAccount() {
        return accountServiceImp.findAllAccount();
    }

    @PostMapping("/")
    public void createAccount(@RequestBody Account account) {
        this.accountServiceImp.createAccount(account);
    }

    @PutMapping("/{id}")
    public void updateAccount(@PathVariable("id") Long accountId,@RequestBody Account account){
        this.accountServiceImp.updateAccount(accountId,account);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable("id") Long accountId){
        this.accountServiceImp.deleteAccount(accountId);
    }
}
