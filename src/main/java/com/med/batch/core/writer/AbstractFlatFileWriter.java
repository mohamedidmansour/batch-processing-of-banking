package com.med.batch.core.writer;

import com.med.batch.enums.Deliminator;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;

public abstract class AbstractFlatFileWriter<T> implements ICreateWriter<T> {
    private final Resource resource;

    protected AbstractFlatFileWriter(Resource resource) {
        this.resource = resource;
    }

    @Override
    public ItemWriter<T> createWriter() {
        validations();
        return new FlatFileItemWriterBuilder<T>()
                .name(getNameWriter())
                .append(isAppend())
                .delimited()
                .delimiter(getDelimiter().getDelimiter())
                .names(getNames())
                .build();
    }

    private void validations() {
        Assert.state(resource.exists(), "Resource does not exist");
        Assert.isTrue(resource.isReadable(), "Resource does not read");
        Assert.hasText(resource.getFilename(), "Resource must have a file name");

        Assert.hasText(getNameWriter(), "Name writer must have a name");
    }

    protected Deliminator getDelimiter() {
        return Deliminator.COMMA;
    }

    protected boolean isAppend() {
        return true;
    }


    protected String getNameWriter() {
        return getClassType().getName().toUpperCase().concat("-FLAT-FILE-WRITER");
    }

    protected abstract String[] getNames();

    protected abstract Class<? extends T> getClassType();
}
