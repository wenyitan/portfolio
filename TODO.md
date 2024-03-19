SELECT round(total/count, 2) as average, count, total, ticker_symbol from (SELECT sum(number) as count, sum(price*number) as total, ticker_symbol FROM TRANSACTION group by ticker_symbol);
