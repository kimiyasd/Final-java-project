import java.util.ArrayList;

public class Admin implements IAllUser{
    private String username;
    private String password;

    private AdminDashboard dashboard;

    public Admin(String username, String password, OnlineShop shop) {
        this.username = username;
        this.password = password;
        this.dashboard = new AdminDashboard(this, shop);
    }


    public ArrayList<Transaction> getTransactionsToConfirm() {
        return transactionsToConfirm;
    }

    private ArrayList  <Transaction> transactionsToConfirm = new ArrayList<>();

    public ArrayList<CertificationRequest> getCertificationRequests() {
        return certificationRequests;
    }
    public void addCertificationRequest(CertificationRequest request) {
        certificationRequests.add(request);
    }

    private ArrayList <CertificationRequest> certificationRequests = new ArrayList<>();

    public ArrayList<FundRequest> getFundRequests() {
        return fundRequests;
    }

    private ArrayList <FundRequest> fundRequests = new ArrayList<>();

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public IDashboard getDashboard() {
        return dashboard;
    }

    @Override
    public void showProfile() {
        System.out.println("Admin: " + username);
    }

}
