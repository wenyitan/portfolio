package com.wenyi.portfolio.services;

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

    public Map<String, Integer> retrieveStockCount() {
        Map<String, Integer> result = new HashMap<>();
        transactionRepo.getStockCount().stream().forEach(stock-> {
            String ticker = stock.get("TICKER");
            String total = String.valueOf(stock.get("TOTAL"));
            result.put(ticker, Integer.parseInt(total));
        });
        return result;
    }

    public Map<String, Float> getAveragePrice() {
        Map<String, Long> prices = new HashMap<>();
        Map<String, Integer> allCounts = new HashMap<>();
        Map<String, Float> result = new HashMap<>();
        List<Transaction> transactions = retrieveAllTransactions();
        transactions.stream().forEach(transaction -> {
            String ticker = transaction.getTickerSymbol();
            Long cost = transaction.getPrice();
            Integer count = transaction.getNumber();
            if (prices.containsKey(ticker)) {
                prices.put(ticker, prices.get(ticker) + cost * count);
            } else {
                prices.put(ticker, cost * count);
            }
            if (allCounts.containsKey(ticker)) {
                allCounts.put(ticker, allCounts.get(ticker) + count);
            } else {
                allCounts.put(ticker, count);
            }
        });
        prices.keySet().stream().forEach(ticker-> {
            Long totalPrice = prices.get(ticker);
            Integer totalCount = allCounts.get(ticker);
            Float averagePrice = Float.valueOf((float) totalPrice/totalCount);
            result.put(ticker, averagePrice);
        });
        return result;
    }

    public Map<String, Float> getTotalPrice() {
        Map<String, Float> result = new HashMap<>();
        Map<String, Integer> stockCounts = retrieveStockCount();
        Map<String, Float> averagePrices = getAveragePrice();
        stockCounts.keySet().forEach(ticker->{
            Integer count = stockCounts.get(ticker);
            Float averagePrice = averagePrices.get(ticker);
            Float total = count * averagePrice;
            result.put(ticker, total);
        });
        return result;
    }
}
