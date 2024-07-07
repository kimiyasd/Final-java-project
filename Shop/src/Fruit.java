public class Fruit extends Product {
     String[] comments={"the taste got me","SO FRESH!!"};
    public Fruit(String name, double price, int quantity, Seller seller, String[] comments) {
        super(name, price, quantity, seller,comments);
    }
}
