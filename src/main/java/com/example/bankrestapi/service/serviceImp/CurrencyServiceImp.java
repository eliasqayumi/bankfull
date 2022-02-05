package com.example.bankrestapi.service.serviceImp;

import com.example.bankrestapi.exception.NotFoundException;
import com.example.bankrestapi.model.Currency;
import com.example.bankrestapi.repository.CurrencyRepository;
import com.example.bankrestapi.service.service.CurrencyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyServiceImp implements CurrencyService {
    private CurrencyRepository currencyRepository;

    public CurrencyServiceImp(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
        Currency USDToSEK= new Currency(1,"USD to SEK",22);
        Currency SEKToUSD= new Currency(2,"SEK to USD",22);
        Currency EURtoSEK= new Currency(3,"EUR to SEK",22);
        Currency SEKToEUR= new Currency(4,"SEK to EUR",22);
        Currency EURToUSD= new Currency(5,"EUR to USD",22);
        Currency USDToEUR= new Currency(6,"USD to EUR",22);
        this.currencyRepository.save(USDToEUR);
        this.currencyRepository.save(SEKToEUR);
        this.currencyRepository.save(SEKToUSD);
        this.currencyRepository.save(EURtoSEK);
        this.currencyRepository.save(USDToSEK);
        this.currencyRepository.save(EURToUSD);

    }

    @Override
    public void createCurrency(Currency currency) {
        this.currencyRepository.save(currency);
    }

    @Override
    public Currency updateCurrency(Integer currencyId,Currency currency) {
        Currency updateCurrency=this.currencyRepository.findById(currencyId).orElseThrow();
        updateCurrency.setCurrencyType(currency.getCurrencyType());
        updateCurrency.setValue(currency.getValue());
        return this.currencyRepository.save(currency);
    }

    @Override
    public List<Currency> getAllCurrency() {
        return this.currencyRepository.findAll();
    }

    @Override
    public void deleteCurrency(Integer currencyId) {
        this.currencyRepository.deleteById(currencyId);
    }

    @Override
    public Currency findCurrencyByCurrencyType(String currencyType) {
        return this.currencyRepository.findByCurrencyType(currencyType).orElseThrow(
                () -> new NotFoundException("Currency by " + currencyType + " was not found"));
    }
}
