import java.util.*;

public class Product {
    public String name;
    public double price;
    public int quantity;
    public Seller seller;
    public String[] comments;

    public Product(String name, double price, int quantity, Seller seller, String[] comments) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.seller = seller;
        this.comments = comments != null ? comments : new String[0];
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void addReview(String comment) {
        if (comments == null) {
            comments = new String[1];
            comments[0] = comment;
        } else {
            String[] newComments = new String[comments.length + 1];
            for (int i = 0; i < comments.length; i++) {
                newComments[i] = comments[i];
            }
            newComments[comments.length] = comment;
            comments = newComments;
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return
                "item='" + name + '\'' +
                ", price=" + price +
                ", available items=" + quantity +
                ", seller=" + seller +
                ", comments=" + Arrays.toString(comments) +
                '}';
    }
}
