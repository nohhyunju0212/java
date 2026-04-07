package kr.co.javaex.sec23.domain;

public class Order {

    int orderID;
    String userID;
    int pID;
    String name;
    int price;
    int qty;

    public Order() {}

    public Order(int orderID, String userID, int pID, String name, int price, int qty) {
        this.orderID = orderID;
        this.userID = userID;
        this.pID = pID;
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    public int getOrderID() {
        return orderID;
    }

    public String getUserID() {
        return userID;
    }

    public int getpID() {
        return pID;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }
}