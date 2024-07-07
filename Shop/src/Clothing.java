
public class Clothing extends Product {
    public int size;
    public Clothing(String name, double price, int quantity, int size, Seller seller,String[] comments) {
        super(name, price, quantity, seller,comments);
        this.size = size;
    }
}