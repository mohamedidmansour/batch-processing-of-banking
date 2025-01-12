package com.med.batch.core.writer;

import org.springframework.batch.item.ItemWriter;

public interface ICreateWriter<T> {
    ItemWriter<T> createWriter();
}
