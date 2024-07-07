public class Order {

    public OnlineShop shop;
    public User user;
    public ShoppingCart cart;

    public Order(OnlineShop shop, User user, ShoppingCart cart) {
        this.shop = shop;
        this.user = user;
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "Order for " + user.getUsername() + " from " + shop.getName() + " with " + cart.products.size() + " products.";
    }
}
