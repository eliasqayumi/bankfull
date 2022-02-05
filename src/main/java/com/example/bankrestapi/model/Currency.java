package com.example.bankrestapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Currency {
    @Id
    @Column(name = "currency_Id", nullable = false)
    private int currencyId;

    @Column(name = "currency_type", nullable = false)
    private String currencyType;

    @Column(name = "value", nullable = false)
    private int value;
}
