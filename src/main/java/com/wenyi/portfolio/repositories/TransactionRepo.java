package com.wenyi.portfolio.repositories;

import com.wenyi.portfolio.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {
    public List<Transaction> findAll();

    @Query(nativeQuery = true, value = "SELECT TICKER_SYMBOL as TICKER, SUM(NUMBER) as TOTAL FROM TRANSACTION GROUP BY TICKER_SYMBOL")
    public List<Map<String, String>> getStockCount();
}
