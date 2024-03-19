package com.wenyi.portfolio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Integer number;
    private Long price;
    private String tickerSymbol;

    public Transaction(Integer number, Long price, String tickerSymbol) {
        this.number = number;
        this.price = price;
        this.tickerSymbol = tickerSymbol;
    }

    public Transaction() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", number=" + number +
                ", price=" + price +
                ", tickerSymbol='" + tickerSymbol + '\'' +
                '}';
    }
}
