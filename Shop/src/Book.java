public class Book extends Product {
    public String writer;
    public Book(String name, double price, int quantity, String writer, Seller seller,String[] comments) {
        super(name, price, quantity, seller,comments);
        this.writer = writer;
    }
}
