package com.example.bankrestapi.Controller;

import com.example.bankrestapi.model.Transaction;
import com.example.bankrestapi.service.serviceImp.TransactionServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions/")
public class TransactionController {
    private TransactionServiceImp transactionServiceImp;

    public TransactionController(TransactionServiceImp transactionServiceImp) {
        this.transactionServiceImp = transactionServiceImp;
    }

    @PostMapping("/")
    public void createTransaction(@RequestBody Transaction transaction) {
        this.transactionServiceImp.createTransaction(transaction);
    }

    @GetMapping("/")
    public List<Transaction> getAllTransaction() {
        return this.transactionServiceImp.findAllTransaction();
    }

    @PutMapping("/{id}")
    public Transaction updateTransaction(@PathVariable("id") Long transactionId, @RequestBody Transaction transaction) {
        return this.transactionServiceImp.updateTransaction(transactionId, transaction);
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable("id") Long transactionId) {
        this.transactionServiceImp.deleteTransaction(transactionId);
    }

}
