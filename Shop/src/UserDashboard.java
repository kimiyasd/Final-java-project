import java.util.ArrayList;
import java.util.Scanner;

public class UserDashboard implements IDashboard{
    private User user;
    private OnlineShop shop;
    public UserDashboard(User user, OnlineShop shop) {
        this.user = user;
        this.shop = shop;
    }
    @Override
    public void showDashboard() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome " + user.getUsername());
        System.out.println("Your balance is: " + user.getWallet().getBalance());
        System.out.println("Please choose an option:");
        System.out.println("0. Show purchased products");
        System.out.println("1. Show your orders");
        System.out.println("2. Show your cart");
        System.out.println("3. Search for a product");
        System.out.println("4. Request funds");
        System.out.println("5. Logout");
        String choice = scanner.nextLine();
        switch (choice) {
            case "0":
                showPurchasedProducts();
                break;
            case "1":
                showOrders();
                break;
            case "2":
                showCart();
                break;
            case "3":
                searchProduct();
                break;
            case "4":
                requestFunds();
                break;

            case "5":
                IntroPage.Intro(shop);
                break;
            default:
                System.out.println("Invalid choice");
                showDashboard();
        }
    }
    public void showOrders() {
        ArrayList<Order> orders = user.getOrders();
        if (orders.size() == 0) {
            System.out.println("You have no orders");
        } else {
            for (Order order : orders) {
                System.out.println(order.toString());
            }
        }
    }
    public void requestFunds() {
        System.out.println("Please enter the amount you want to request");
        Scanner scanner = new Scanner(System.in);
        double amount = scanner.nextDouble();
        shop.mainAdmin.getFundRequests().add(new FundRequest(user, amount));
        System.out.println("Request sent to admin, please wait for confirmation");
        showDashboard();
    }
    public void searchProduct() {
        System.out.println("Please enter the name of the product you want to search for");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Product product = Stock.getProduct(name);
        if (product != null) {
            System.out.println(product);
            System.out.println("Press 1 to add to cart or 2 to go back");
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                if(product.getQuantity() == 0){
                    System.out.println("Product is out of stock");
                    showDashboard();
                }
                user.getCart().addProduct(product);
                product.setQuantity(product.getQuantity() - 1);
                System.out.println("Product added to cart");
                showDashboard();
            } else {
                showDashboard();
            }
        } else {
            System.out.println("Product not found");
            showDashboard();
        }

    }

    @Override
    public void showProfile() {

    }
    public void showPurchasedProducts() {
        ArrayList<Product> purchasedProducts = user.getPurchasedProducts();
        if (purchasedProducts.size() == 0) {
            System.out.println("You have no purchased products");
            showDashboard();
        } else {
            System.out.println("Your purchased products:");
            System.out.println("Choose a product to send your review:");
            for (int i = 0; i < purchasedProducts.size(); i++) {
                System.out.println(i + ". " + purchasedProducts.get(i).toString());
            }
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();
            Product product = purchasedProducts.get(choice);
            System.out.println("Please enter your review:");
            String review = scanner.nextLine();
            product.addReview(review);
            showDashboard();
        }
    }

    public void showCart() {
        ShoppingCart cart = user.getCart();
        if (cart.products.size() == 0) {
            System.out.println("Your cart is empty");
        } else {
            for (Product product : cart.products) {
                System.out.println(product);
                System.out.println("Press 1 to confirm order or 2 to go back");
                Scanner scanner = new Scanner(System.in);
                String choice = scanner.nextLine();
                if (choice.equals("1")) {
                    TransactionHandler.setUpTransactions(new Order(cart.shop, user, cart));
                    System.out.println("Order sent to admin, please wait for confirmation");
                    showDashboard();
                } else {
                    showDashboard();
                }
            }
        }
        showDashboard();
    }
}
