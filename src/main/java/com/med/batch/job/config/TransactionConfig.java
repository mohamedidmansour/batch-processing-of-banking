package com.med.batch.job.config;

import com.med.batch.core.reader.ICreateReader;
import com.med.batch.core.writer.ICreateWriter;
import com.med.batch.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.job.builder.SimpleJobBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

@RequiredArgsConstructor
@Component
public class TransactionConfig {

    private final ICreateReader<Transaction> transactionFlatFileReader;
    private final ICreateWriter<Transaction> transactionFlatFileWriter;
    private final ItemProcessor<Transaction, Transaction> transactionProcessor;

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;


    @Bean
    public Step transactionStep1() {
        return new StepBuilder("STEP1-TRANSACTION", jobRepository)
                .<Transaction, Transaction>chunk(10, transactionManager)
                .reader(transactionFlatFileReader.createReader())
                .processor(transactionProcessor)
                .writer(transactionFlatFileWriter.createWriter())
                .build();
    }

    @Bean
    public Job transactionJob1() {
        return new JobBuilder("JOB1-TRANSACTION", jobRepository)
                .start(transactionStep1())
                .build();
    }
}
