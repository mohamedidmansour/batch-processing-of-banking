package com.med.batch.core.reader;

import com.med.batch.enums.Deliminator;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;

public abstract class AbstractFlatFileReader<T> implements ICreateReader<T> {
    private final static int DEFAULT_LINES_TO_SKIP = 1;
    private final Resource resource;

    protected AbstractFlatFileReader(Resource resource) {
        this.resource = resource;
    }

    @Override
    public ItemReader<T> createReader() {
        validations();
        return new FlatFileItemReaderBuilder<T>()
                .name(getReaderName().toUpperCase())
                .resource(resource)
                .linesToSkip(getLineToSkip())
                .strict(true)
                .lineMapper(lineMapper())
                .build();

    }

    private void validations() {
        Assert.state(resource.exists(), "Resource does not exist");
        Assert.isTrue(resource.isReadable(), "Resource does not read");
        Assert.hasText(resource.getFilename(), "Resource must have a file name");

        Assert.hasText(getReaderName(), "Name reader must have a name");
    }

    private LineMapper<T> lineMapper() {
        DefaultLineMapper<T> lineMapper = new DefaultLineMapper<>();
        lineMapper.setFieldSetMapper(setFieldSetMapper());
        lineMapper.setLineTokenizer(lineTokenizer());
        return lineMapper;
    }

    private LineTokenizer lineTokenizer() {
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setDelimiter(getDelimiter().getDelimiter());
        tokenizer.setStrict(false);
        tokenizer.setNames(getNames());

        return tokenizer;
    }

    private FieldSetMapper<T> setFieldSetMapper() {
        BeanWrapperFieldSetMapper<T> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(getClassType());
        return fieldSetMapper;
    }

    protected Deliminator getDelimiter() {
        return Deliminator.COMMA;
    }

    protected int getLineToSkip() {
        return DEFAULT_LINES_TO_SKIP;
    }

    protected String getReaderName() {
        return getClassType().getName().toUpperCase().concat("-FLAT-FILE-READER");
    }

    protected abstract Class<? extends T> getClassType();

    protected abstract String[] getNames();
}
