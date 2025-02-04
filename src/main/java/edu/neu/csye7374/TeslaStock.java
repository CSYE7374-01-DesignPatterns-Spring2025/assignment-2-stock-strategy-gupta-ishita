package edu.neu.csye7374;
public class TeslaStock extends Stock{
    public TeslaStock() {
        super("102", "Tesla", 306.5, "This is Tesla stock");
        setStrategy(new BearStrategy()); // Default to Bull Market Strategy

    }
    @Override
    public int getMetric() {
        // Algorithm for metric evaluation = price change = current price - previous price
        double currentPrice = getPrice();
        int metric = (int) (0.8 * currentPrice);
        setMetric(metric);
        return metric;
    }

    @Override
    public void setBid(String bid) {
        super.setBid(bid);
        if (bid == null || bid.isEmpty()) {
            System.out.println("Invalid bid, no update made.");
            return;
        }
        double currentBid = Double.parseDouble(bid);

        // Fluctuating price as per current bid
        double price = getPrice();

        if (price > currentBid) {
            price = price + 0.05 * currentBid;
        } else if (price < currentBid) {
            price = price - 0.05 * currentBid;
        }
        setPrice(price);
    }

}
