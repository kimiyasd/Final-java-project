import java.util.*;

public class ShoppingCart {
    public ArrayList<Product> products;
    public double total;
    public int itemCount;

    public OnlineShop shop;

    public ShoppingCart(OnlineShop shop) {
        this.products = new ArrayList<>();
        this.total = 0;
        this.itemCount = 0;
        this.shop = shop;
    }
    public void emptyCart() {
        this.products.clear();
        this.total = 0;
        this.itemCount = 0;
    }
    public void removeProduct(Product product) {
        this.products.remove(product);
        this.total -= product.price;
        this.itemCount--;
    }
    public void addProduct(Product product) {
        this.products.add(product);
        this.total += product.price;
        this.itemCount++;
    }
}
