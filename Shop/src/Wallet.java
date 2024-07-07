public class Wallet {
    private double balance;
    public Wallet(double balance) {
        this.balance = balance;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void addMoney(double amount) {
        balance += amount;
    }
    public void deductMoney(double amount) {
        balance -= amount;
    }
    public void hasSufficientBalance(double amount) {
        if (balance < amount) {
            System.out.println("Inadequate balance");
        }
    }

}
