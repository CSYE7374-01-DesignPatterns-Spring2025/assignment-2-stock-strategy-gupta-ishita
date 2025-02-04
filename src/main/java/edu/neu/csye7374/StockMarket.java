package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {
    private static StockMarket instance;
    private List<String> bidHistory;

    private StockMarket() {
        this.bidHistory = new ArrayList<>();
    }

    public static StockMarket getInstance() {
        if (instance == null) {
            instance = new StockMarket();
        }
        return instance;
    }

    public void addBid(String bid) {
        bidHistory.add(bid);
    }

    public List<String> getBidHistory() {
        return bidHistory;
    }
}

