public class Seller extends WalletHolder implements IAllUser{
    private SellerDashboard dashboard;

    public Boolean getCertified() {
        return isCertified;
    }

    public void setCertified(Boolean certified) {
        isCertified = certified;
    }

    Boolean isCertified;
    public Seller(String username, String password, Wallet wallet, OnlineShop shop, Boolean isCertified) {
        super(username, password, wallet);
        this.isCertified = isCertified;
        this.dashboard = new SellerDashboard(this,shop);
        LoginDatas.add(this);
    }

    @Override
    public IDashboard getDashboard() {
        return dashboard;
    }

    @Override
    public void showProfile() {
        System.out.println("Seller: " + getUsername());
        System.out.println("Wallet balance: " + getWallet().getBalance());
    }
}
