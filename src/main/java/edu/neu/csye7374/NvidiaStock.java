package edu.neu.csye7374;

public class NvidiaStock extends Stock{
    private int bidCount;
    public NvidiaStock() {
        super("101", "Nvidia", 200, "This is Nvidia Stock");
        bidCount = 0;
        setStrategy(new BullStrategy()); // Default to Bull Market Strategy
    }

    public int getBidCount() {
        return bidCount;
    }

    public void setBidCount(int bidCount) {
        this.bidCount = bidCount;
    }

    @Override
    public int getMetric() {
        // Algorithm for metric evaluation = 10 * (number of won bids / total number of bids)
        int numberOfWonBids = 1; // assuming only 1 bid wins for nvidia
        int metric = (int) 100 * numberOfWonBids / bidCount;
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
        bidCount++;

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
