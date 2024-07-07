public class Transaction {
    public User user;
    public Seller seller;
    public Product product;

    public double amount;
    public Transaction(User user, Seller seller, double amount, Product product) {
        this.user = user;
        this.seller = seller;
        this.amount = amount;
        this.product = product;
    }

    public void processTransaction() {
        if (user.getWallet().getBalance() < amount) {
            System.out.println("Inadequate balance");
            return;
        }
        user.getWallet().deductMoney(amount);
        seller.getWallet().addMoney(amount*0.9);
        user.shop.setProfit(user.shop.getProfit() + amount*0.1);
        user.getPurchasedProducts().add(product);
        user.getCart().removeProduct(product);
    }

    @Override
    public String toString() {
        return "user: " + user.getUsername() + " seller: " + seller.getUsername() + " amount: " + amount;
    }
}
