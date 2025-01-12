package com.med.batch.core.processor;

import lombok.NonNull;
import org.springframework.batch.item.ItemProcessor;

public abstract class AbstractProcessor<I, O> implements ItemProcessor<I, O> {

    @Override
    public O process(@NonNull I item) throws Exception {
        doBeforeProcessor(item);
        if (validate(item)) {
            return doProcess(item);
        }
        return null;
    }

    protected abstract boolean validate(I input);
    protected abstract O doProcess(I input);
    protected abstract void doBeforeProcessor(I input);
}
