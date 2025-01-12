package com.med.batch.job.transaction.reader;

import com.med.batch.core.reader.AbstractFlatFileReader;
import com.med.batch.enums.TransactionFields;
import com.med.batch.model.Transaction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class TransactionFlatFileReader extends AbstractFlatFileReader<Transaction> {

    protected TransactionFlatFileReader(@Value("${batch.transaction.input}") Resource resource) {
        super(resource);
    }

    @Override
    protected Class<? extends Transaction> getClassType() {
        return Transaction.class;
    }

    @Override
    protected String[] getNames() {
        return TransactionFields.getAllFieldNames();
    }
}
