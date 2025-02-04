package edu.neu.csye7374;

public class BullStrategy implements StrategyInterface{
    @Override
    public double calculateBid(double price) {
        // Bull market strategy: increase the price by 5%
        return price * 1.05;
    }
}
