package com.med.batch.model;

import com.med.batch.enums.AccountType;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String accountNumber;
    private BigDecimal initialBalance;
    private AccountType type;
    @Transient
    private List<Transaction> transactions;
}
