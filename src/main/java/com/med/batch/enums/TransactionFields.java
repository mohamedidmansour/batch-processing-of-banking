package com.med.batch.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum TransactionFields {
    ID("id"),
    ACCOUNT_NUMBER("accountNumber"),
    AMOUNT("amount"),
    TYPE("type"),
    DATE_OPERATION("dateOperation"),
    DESCRIPTION("description");

    private final String fieldName;

    TransactionFields(String fieldName) {
        this.fieldName = fieldName;
    }

    public static String[] getAllFieldNames() {
        return Arrays.stream(values())
                .map(TransactionFields::getFieldName)
                .toArray(String[]::new);
    }
}
