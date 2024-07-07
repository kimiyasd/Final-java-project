public class FundRequest {
    private User user;
    private double amount;

    public FundRequest(User user, double amount) {
        this.user = user;
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }
    public void approve() {
        user.getWallet().addMoney(amount);
    }

    @Override
    public String toString() {
        return "Fund request of " + amount + " from " + user.getUsername();
    }
}
