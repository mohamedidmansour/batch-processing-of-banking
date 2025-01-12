package com.med.batch.job.transaction.writer;

import com.med.batch.core.writer.AbstractFlatFileWriter;
import com.med.batch.enums.TransactionFields;
import com.med.batch.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class TransactionFlatFileWriter extends AbstractFlatFileWriter<Transaction> {

    @Autowired
    protected TransactionFlatFileWriter(@Value("${batch.transaction.output}") Resource resource) {
        super(resource);
    }

    @Override
    protected String[] getNames() {
        return TransactionFields.getAllFieldNames();
    }

    @Override
    protected Class<? extends Transaction> getClassType() {
        return Transaction.class;
    }
}
