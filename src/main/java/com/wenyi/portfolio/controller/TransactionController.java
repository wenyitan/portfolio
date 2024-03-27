package com.wenyi.portfolio.controller;

import com.wenyi.portfolio.model.StockReport;
import com.wenyi.portfolio.model.Transaction;
import com.wenyi.portfolio.repositories.TransactionRepo;
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

    @GetMapping("/transactions/get-report")
    private List<StockReport> getAllReport() {
        return transactionService.getReport();
    }

}
