package com.wenyi.portfolio.services;

import com.wenyi.portfolio.model.StockReport;
import com.wenyi.portfolio.model.Transaction;
import com.wenyi.portfolio.repositories.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepo transactionRepo;

    public List<Transaction> retrieveAllTransactions() {
        return transactionRepo.findAll();
    }

    public List<Transaction> retrieveTransactionsByTickerSymbol(String tickerSymbol) {
        return retrieveAllTransactions()
                .stream().filter(transaction -> transaction.getTickerSymbol().equalsIgnoreCase(tickerSymbol))
                .toList();
    }

    public List<StockReport> getReport() {
        return transactionRepo.getStockReport();
    }
}
