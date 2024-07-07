import java.util.ArrayList;
import java.util.Scanner;
public class User extends WalletHolder implements IAllUser {
    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    private ArrayList<Order> orders;

    public UserDashboard getDashboard() {
        return dashboard;
    }

    private UserDashboard dashboard;

    public ShoppingCart getCart() {
        return cart;
    }

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }

    private ShoppingCart cart;
    public OnlineShop shop;

    public ArrayList<Product> getPurchasedProducts() {
        return purchasedProducts;
    }

    public ArrayList<Product> purchasedProducts = new ArrayList<>();

    public User(String username, String password, Wallet wallet, OnlineShop shop) {
        super(username, password, wallet);
        this.orders = new ArrayList<>();
        this.dashboard = new UserDashboard(this, shop);
        this.cart = new ShoppingCart(shop);
        this.shop = shop;
        LoginDatas.add(this);

    }
    public void showProfile() {
        System.out.println("User: " + getUsername());
        System.out.println("Wallet balance: " + getWallet().getBalance());
    }
}
