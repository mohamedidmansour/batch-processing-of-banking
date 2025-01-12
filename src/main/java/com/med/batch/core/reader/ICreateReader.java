package com.med.batch.core.reader;

import org.springframework.batch.item.ItemReader;

public interface ICreateReader<T> {
    ItemReader<T> createReader();
}
