package com.wenyi.portfolio;

import com.wenyi.portfolio.model.Transaction;
import com.wenyi.portfolio.repositories.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private ApplicationContext context;
    @Autowired
    private TransactionRepo transactionRepo;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        Transaction transaction1 = new Transaction(3, 112L, "AAPL");
//        Transaction transaction2 = new Transaction(5, 178L, "TSLA");
//        transactionRepo.save(transaction1);
//        transactionRepo.save(transaction2);
    }
}
