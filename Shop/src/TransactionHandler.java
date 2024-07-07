public class TransactionHandler {
    public static Stock stock;
    public static void processOrder(Order order) {
        int total = 0;
        for (Product product : order.cart.products) {
            total += product.price;
        }
        if (order.user.getWallet().getBalance()<total) {
            System.out.println("Inadequate balance");
            return;
        }
        else {

        }
    }
    public static void setUpTransactions(Order order){
        User user = order.user;
        for (Product product : order.cart.products) {
            Seller seller = product.seller;
            Transaction transaction = new Transaction(user, seller, product.price, product);
            Admin admin = order.shop.mainAdmin;
            admin.getTransactionsToConfirm().add(transaction);
        }
    }

    public static void updateInventory(Stock stock) {

    }
}
