package domain;

public class Product{

        public int pID;
        public String name;
        public int price;
        public String ex;
        public int pcs;
        public String state;
        public int cID;

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

    }
