package com.example.bankrestapi.service.service;

import com.example.bankrestapi.model.Currency;

import java.util.List;

public interface CurrencyService {
    void createCurrency(Currency currency);
    Currency updateCurrency(Integer currencyId,Currency currency);
    List<Currency> getAllCurrency();
    void deleteCurrency(Integer currencyId);
    Currency findCurrencyByCurrencyType(String currencyType);

}
