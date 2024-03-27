package com.wenyi.portfolio.model;

public interface StockReport {
    Float getAverage();
    Integer getCount();
    Float getTotal();
    String getTicker_symbol();
}