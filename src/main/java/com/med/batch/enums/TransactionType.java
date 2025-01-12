package com.med.batch.enums;

import lombok.Getter;

@Getter
public enum TransactionType {
    CREDIT("Credit"),
    DEBIT("Debit");

    final String value;

    TransactionType(String value) {
        this.value = value;
    }
}
