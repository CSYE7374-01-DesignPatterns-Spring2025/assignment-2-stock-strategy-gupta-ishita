package edu.neu.csye7374;

public class StockB extends StockAPI implements Tradable {
  private int metric;
  private int buyCount;
  private int sellCount;

  public StockB(String id, double price, String description, StrategyInterface strategy) {
    super(id, price, description, strategy);
    this.metric = 5;
    this.buyCount = 0;
    this.sellCount = 0;
  }

  @Override
  public void setBid(String bid) {
    double bidPrice = Double.parseDouble(bid);
    if (bidPrice > 0) { // Buy
      buyCount++;
      metric += 3;
    } else { // Sell
      sellCount++;
      metric -= 1;
    }
    adjustPrice();
  }

  private void adjustPrice() {
    double adjustmentFactor = (getMetric() * 0.55);
    setPrice(getPrice() + adjustmentFactor);
  }

  @Override
  public int getMetric() {
    int tempDiff = buyCount - sellCount;
    if (tempDiff == 0) {
      return 0;
    }
    metric /= tempDiff;
    metric = (int) metric;
    return metric;
  }
}