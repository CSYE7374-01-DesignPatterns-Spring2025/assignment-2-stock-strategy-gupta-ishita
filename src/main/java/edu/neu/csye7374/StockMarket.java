package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {
    // Add stock to the stock market
    private static List<Stock> stocks;
    public StockMarket() {
        stocks = new ArrayList<>();
    }

    public void addStock(Stock stock) {
        System.out.println("Stock " + stock.getiD() + " has been added to the stock market.");
        stocks.add(stock);
    }

    // Trade stock by placing a bid
    public void tradeStock(String stockName, String bid) {
        System.out.println("Trading " + stockName + " stock for a bid of $" + bid + ".");
        for (Stock stock : stocks) {
            if (stock.getName().equalsIgnoreCase(stockName)) {
                stock.setBid(bid);
            }
        }
    }

    // Show details of a specific stock by name
    public void showStock(String name) {
        for (Stock stock : stocks) {
            if (stock.getName().equalsIgnoreCase(name)) {
                System.out.println(stock);
            }
        }
    }

    // Method to execute all market operations (this consolidates all trading logic)
    public static void demo() {
        StockMarket market = new StockMarket(); // Created object to initialize the global variables
        Stock nvidia = new NvidiaStock();
        Stock tesla = new TeslaStock();

        market.addStock(nvidia);
        market.addStock(tesla);

        // Trade tesla stock with multiple bids
        String[] bids3 = {"162.22", "151.34", "177.14", "146.32", "162.22", "149.22"};
        nvidia.setStrategy(new BullStrategy());
        System.out.println("\n============NVIDIA Stock (Bull Market)===================\n");
        for (String bid : bids3) {
            market.tradeStock("NVIDIA", bid);
            market.showStock("Nvidia");
        }
        System.out.println("============End of NVIDIA Stock (Bull Market)===================\n");

        // Switch to Bear Market Strategy for NVIDIA
        nvidia.setStrategy(new BearStrategy());
        System.out.println("\n============NVIDIA Stock (Bear Market)===================\n");
        for (String bid : bids3) {
            market.tradeStock("NVIDIA", bid);
            market.showStock("Nvidia");
        }
        System.out.println("============End of NVIDIA Stock (Bear Market)===================\n");

        // Trade Tesla stock with multiple bids
        String[] bids1 = {"307.00", "301", "308", "309", "308.5", "302"};
        tesla.setStrategy(new BullStrategy());
        System.out.println("\n============TESLA Stock (Bull Market) ===================\n");
        for (String bid : bids1) {
            market.tradeStock("Tesla", bid);
            market.showStock("Tesla");
        }
        System.out.println("============End of TESLA Stock (Bull Market)===================\n");

        // Switch to Bear Market Strategy for NVIDIA
        tesla.setStrategy(new BearStrategy());
        System.out.println("\n============TESLA Stock (Bear Market) ===================\n");
        for (String bid : bids1) {
            market.tradeStock("Tesla", bid);
            market.showStock("Tesla");
        }
        System.out.println("============End of TESLA Stock (Bear Market) ===================\n");
    }

}
