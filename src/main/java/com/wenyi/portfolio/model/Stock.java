package com.wenyi.portfolio.model;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Stock {
    private Long id;
    private String tickerSymbol;
    private String name;
    private Long price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Stock(String tickerSymbol, String name, Long price) {
        this.tickerSymbol = tickerSymbol;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", tickerSymbol='" + tickerSymbol + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
