package com.med.batch.enums;

import lombok.Getter;

@Getter
public enum AccountType {
    COURANT("COURANT"),
    EPARGNE("EPARGNE");

    final String value;

    AccountType(String value) {
        this.value = value;
    }
}