package kr.co.javaex.sec23.domain;

public class Cart {

    int cartID;
    String userID;
    int pID;
    String name;
    int price;
    int qty;

    public Cart() {
    }

    public Cart(int cartID, String userID, int pID, String name, int price, int qty) {
        this.cartID = cartID;
        this.userID = userID;
        this.pID = pID;
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    public int getCartID() {
        return cartID;
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

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setpID(int pID) {
        this.pID = pID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}