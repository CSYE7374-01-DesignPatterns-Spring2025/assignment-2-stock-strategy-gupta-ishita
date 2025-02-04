package edu.neu.csye7374;

public class StockAPI {
    private String iD;
    private String name;
    private double price;
    private String description;

    public StockAPI(String iD, String name, double price, String description) {
        this.iD = iD;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "StockAPI{" +
                "iD='" + iD + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
