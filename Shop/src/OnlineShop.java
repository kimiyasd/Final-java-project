import java.util.ArrayList;

public class OnlineShop {
    public String name;
    public String website;
    public String phoneNumber;
    private LoginDatas loginDatas;

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    private double profit;

    public ArrayList<Admin> admins;

    public void setMainAdmin(Admin mainAdmin) {
        this.mainAdmin = mainAdmin;
        LoginDatas.add(mainAdmin);
    }

    public Admin mainAdmin;

    public Stock stock;

    public OnlineShop(String name, String website, LoginDatas loginDatas, Admin mainAdmin) {
        this.name = name;
        this.website = website;
        this.loginDatas = loginDatas;
        this.mainAdmin = mainAdmin;
        this.admins = new ArrayList<>();
        this.stock = new Stock();
        this.profit = 0;
    }

    public String getName() {
        return name;
    }
}
