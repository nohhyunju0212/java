package kr.co.javaex.sec23.domain;

public class Product {

    int pID;
    String name;
    int price;
    String ex;
    int pcs;
    String state;
    int cID;

    public Product() {
    }

    public Product(int pID, String name, int price, String ex, int pcs, String state, int cID) {
        this.pID = pID;
        this.name = name;
        this.price = price;
        this.ex = ex;
        this.pcs = pcs;
        this.state = state;
        this.cID = cID;
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

    public String getEx() {
        return ex;
    }

    public int getPcs() {
        return pcs;
    }

    public String getState() {
        return state;
    }

    public int getcID() {
        return cID;
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

    public void setEx(String ex) {
        this.ex = ex;
    }

    public void setPcs(int pcs) {
        this.pcs = pcs;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setcID(int cID) {
        this.cID = cID;
    }
}