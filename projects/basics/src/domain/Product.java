package domain;

public class Product {

    private int stock; // not initialized, no constructors
    private char code; // not initialized, no constructors

    public Product(char code, int stock) {
        this.code = code;
        this.stock = stock;
    }

    public int getStock() {
        return this.stock;
    }

    public int getCode() {
        return this.code;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setCode(char code) {
        this.code = code;
    }

    public String toString() {
        return "Product(code:" + code + ", stock:" + stock + ")";
    }
}
