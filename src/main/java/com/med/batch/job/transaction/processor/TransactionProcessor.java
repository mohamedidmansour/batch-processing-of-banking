package com.med.batch.job.transaction.processor;

import com.med.batch.core.processor.AbstractProcessor;
import com.med.batch.model.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TransactionProcessor extends AbstractProcessor<Transaction, Transaction> {
    @Override
    protected boolean validate(Transaction input) {
        return true;
    }

    @Override
    protected Transaction doProcess(Transaction input) {
        return input;
    }

    @Override
    protected void doBeforeProcessor(Transaction input) {
        log.info("Processing transaction {}", input);
    }
}
