package com.med.batch.model;

import com.med.batch.enums.TransactionType;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Transaction {
    String id;                    // Identifiant unique
    String accountNumber;          // Numéro du compte concerné
    BigDecimal amount;          // Montant de l'opération
    TransactionType type;                 // "CREDIT" (argent reçu) ou "DEBIT" (argent sorti)
    LocalDateTime dateOperation; // Date et heure de l'opération
    String description;          // Description de l'opération (ex: "VIREMENT", "RETRAIT DAB")
}