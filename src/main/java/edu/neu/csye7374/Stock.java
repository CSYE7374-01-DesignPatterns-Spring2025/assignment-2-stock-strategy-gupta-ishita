package edu.neu.csye7374;

public class Stock extends StockAPI{

    private String bid;
    private int metric;
    private StrategyInterface strategy;
    public Stock(String iD, String name, double price, String description) {
        super(iD, name, price, description);
        bid = null;
        metric = 0;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        if (bid == null || bid.isEmpty()) {
            System.out.println("Invalid bid, no update made.");
            return;
        }
        this.bid = bid;
    }

    public int getMetric() {
        return this.metric;
    }
    public void setMetric(int metric) {
        this.metric = metric;
    }

    public void setStrategy(StrategyInterface strategy) {
        this.strategy = strategy;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "iD='" + getiD() + '\'' +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", description='" + getDescription() + '\'' +
                ", bid='" + getBid() + '\'' +
                ", metric=" + getMetric() +
                '}';
    }
}
