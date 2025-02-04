package edu.neu.csye7374;

public class StockA extends StockAPI implements Tradable{
  private int metric;
  private int buyCount;
  private int sellCount;

  public StockA(String id, double price, String description, StrategyInterface strategy) {
    super(id, price, description, strategy);
    this.metric = 10;
    this.buyCount = 0;
    this.sellCount = 0;
  }

  @Override
  public void setBid(String bid) {
    double bidPrice = Double.parseDouble(bid);
    if (bidPrice > 0) { // Buy
      buyCount++;
    } else { // Sell
      sellCount++;
    }
    adjustPrice();
  }

  private void adjustPrice() {
    double adjustmentFactor = (getMetric() * 0.44);
    setPrice(getPrice() + adjustmentFactor);
  }

  @Override
  public int getMetric() {
    int tempDiff = buyCount - sellCount;
    metric = metric + tempDiff;
    if (tempDiff > 0 && metric > 0) {
      return metric;
    }
    return -1 * metric;
  }
}