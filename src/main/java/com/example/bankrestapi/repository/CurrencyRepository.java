package com.example.bankrestapi.repository;

import com.example.bankrestapi.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface CurrencyRepository extends JpaRepository<Currency,Integer> {
    Optional<Currency> findByCurrencyType(String currencyType);
}
