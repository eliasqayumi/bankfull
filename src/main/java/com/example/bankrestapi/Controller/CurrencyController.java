package com.example.bankrestapi.Controller;

import com.example.bankrestapi.model.Currency;
import com.example.bankrestapi.service.serviceImp.CurrencyServiceImp;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
    private CurrencyServiceImp currencyServiceImp;

    public CurrencyController(CurrencyServiceImp currencyServiceImp) {
        this.currencyServiceImp = currencyServiceImp;
    }
    @GetMapping("/")
    public List<Currency> getAllCurrency(){
        return this.currencyServiceImp.getAllCurrency();
    }

    @PostMapping("/")
    public void createNewCurrency(@RequestBody Currency currency){
        this.currencyServiceImp.createCurrency(currency);
    }

    @PutMapping("/{id}")
    public void updateCurrency(@PathVariable("id") Integer currencyId, @RequestBody Currency currency){
        this.currencyServiceImp.updateCurrency(currencyId,currency);
    }
}
