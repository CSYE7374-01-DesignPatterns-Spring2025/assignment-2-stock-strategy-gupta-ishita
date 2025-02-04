package edu.neu.csye7374;

public class BearStrategy implements StrategyInterface{

    @Override
    public double calculateBid(double price) {
        // Bear market strategy: decrease the price by 5%
        return price * 0.95;
    }
}