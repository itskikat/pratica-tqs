package stocks;

import java.util.ArrayList;

public class StocksPortfolio {

    private String name;
    private IStockMarketService stockmarket;
    private ArrayList<Stock> stocks = new ArrayList<>();

    public StocksPortfolio(IStockMarketService service) {
        this.stockmarket = service;
    }

    public double getTotalValue() {
        double total = 0.0;

        for(Stock s: this.stocks) {
            String stock_name = s.getName();
            int stock_quantity = s.getQuantity();
            total += (stockmarket.getPrice(stock_name)) * stock_quantity;
        }
        return total;
    }

    public void addStock(Stock s) {
        this.stocks.add(s);
    }


}
