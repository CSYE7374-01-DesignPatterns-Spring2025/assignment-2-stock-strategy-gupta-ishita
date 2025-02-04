package edu.neu.csye7374;

public class PlayStockMarket {
    public static void simulateMarket() {
        // Singleton StockMarket Instance
        StockMarket market = StockMarket.getInstance();

        // Using simple Factories
        StockFactory stockAFactory = StockAFactory.getInstance();
        StockFactory stockBFactory = StockBFactory.getInstance();

        // Create Stock Instances
        StockAPI amazon = stockAFactory.createStock("Amazon", 150.0, "Amazon Stock", new BullStrategy());
        StockAPI nvidia = stockBFactory.createStock("NVIDIA", 100.0, "NVIDIA Stock", new BearStrategy());


        // Using Singleton Factories - one Eager and one Lazy
        StockFactory eagerStockAFactory = EagerStockAFactory.getInstance();
        StockFactory lazyStockBFactory = LazyStockBFactory.getInstance();

        // Create Stock Instances
        StockAPI tesla = eagerStockAFactory.createStock("TSLA", 600.0, "Tesla Stock",  new BullStrategy());
        StockAPI apple = lazyStockBFactory.createStock("AAPL", 95.0, "Apple Stock", new BearStrategy());

        // 6 Bids for each stock - Amazon, Nvidia, Tesla and Apple
        String[] amazonBids = {"160.00", "-160.00", "-150.00", "140.00", "-150.00", "150.00"};
        String[] nvidiaBids = {"105.00", "-95.00", "-110.00", "90.00", "115.00", "100.00"};
        String[] teslaBids = {"600.00", "-590.00", "-610.00", "-614.00", "600.00", "-650.00"};
        String[] appleBids = {"105.00", "-95.00", "-110.00", "90.00", "115.00", "100.00"};

        // Amazon Market Trends
        System.out.println("\n=== Amazon Market Trends (Bull Strategy)===");
        System.out.println("Initial Value: " + amazon);
        for (String bid : amazonBids) {
            amazon.setBid(bid);
            market.addBid("Amazon: " + bid);
            System.out.println("Bid: " + bid);
            System.out.println("Price Post BID: " + amazon);
            System.out.println("Metric: " + amazon.getMetric());
            System.out.println("-------------------------------");
        }

        // Nvidia  Market Trends
        System.out.println("\n=== Nvidia Market Trends (Bear Strategy) ===");
        System.out.println("Initial Value: " + nvidia);
        for (String bid : nvidiaBids) {
            nvidia.setBid(bid);
            market.addBid("Nvidia: " + bid);
            System.out.println("Bid: " + bid);
            System.out.println("Price Post BID: " + nvidia);
            System.out.println("Metric: " + nvidia.getMetric());
            System.out.println("-------------------------------");
        }

        // Tesla Market Trends
        System.out.println("\n=== Tesla Market Trends (Bull Strategy) ===");
        System.out.println("Initial Value: " + tesla);
        for (String bid : teslaBids) {
            tesla.setBid(bid);
            market.addBid("Tesla: " + bid);
            System.out.println("Bid: " + bid);
            System.out.println("Price Post BID: " + tesla);
            System.out.println("Metric: " + tesla.getMetric());
            System.out.println("-------------------------------");
        }

        // Apple Market Trends
        System.out.println("\n=== Apple Market Trends (Bear Strategy) ===");
        System.out.println("Initial Value: " + apple);
        for (String bid : appleBids) {
            apple.setBid(bid); // Process Bid
            market.addBid("Apple: " + bid);
            System.out.println("Bid: " + bid);
            System.out.println("Price Post BID: " + apple);
            System.out.println("Metric: " + apple.getMetric());
            System.out.println("-------------------------------");
        }
    }
}
