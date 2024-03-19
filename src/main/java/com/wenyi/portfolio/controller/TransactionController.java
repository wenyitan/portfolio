package com.wenyi.portfolio.controller;

import com.wenyi.portfolio.model.Transaction;
import com.wenyi.portfolio.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/portfolio")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/transactions")
    private List<Transaction> getAllTransactions() {
        return transactionService.retrieveAllTransactions();
    }

    @GetMapping("/transactions/{tickerSymbol}")
    private List<Transaction> getTransactionsByTickerSymbol(@PathVariable String tickerSymbol) {
        return transactionService.retrieveTransactionsByTickerSymbol(tickerSymbol);
    }

    @GetMapping("/transactions/average-price")
    private Map<String, Float> getAllAveragePrice() {
        return transactionService.getAveragePrice();
    }

    @GetMapping("/transactions/get-stock-count")
    private Map<String, Integer> getStockCounts() {
        return transactionService.retrieveStockCount();
    }

    @GetMapping("/transactions/get-total-price")
    private Map<String, Float> getAllTotalPrice() {
        return transactionService.getTotalPrice();
    }

}
