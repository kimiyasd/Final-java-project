import java.util.ArrayList;
import java.util.Scanner;

public class AdminDashboard implements IDashboard{

    private Admin admin;
    private OnlineShop shop;

    public AdminDashboard(Admin admin, OnlineShop shop) {
        this.admin = admin;
        this.shop = shop;
    }

    @Override
    public void showDashboard() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome " + admin.getUsername());
        System.out.println("You have " + admin.getTransactionsToConfirm().size() + " transactions to confirm");
        System.out.println("You have " + admin.getCertificationRequests().size() + " certification requests");
        System.out.println("You have " + admin.getFundRequests().size() + " fund requests");
        System.out.println("The shop has made " + shop.getProfit() + " profit");
        System.out.println("Please choose an option:");
        System.out.println("1. Show transactions to confirm");
        System.out.println("2. Show certification requests");
        System.out.println("3. Show fund requests to confirm");
        System.out.println("4. Add admin");
        System.out.println("5. List all users");
        System.out.println("6. Logout");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                showTransactionsToConfirm();
                break;
            case "2":
                showCertificationRequests();
                break;
            case "3":
                showFundRequestsToConfirm();
                break;
            case "4":
                addAdmin();
                break;
            case "5":
                showAllUsers();
                break;

            case "6":
                IntroPage.Intro(shop);
                break;
            default:
                System.out.println("Invalid choice");
                showDashboard();
        }

    }

    private void showFundRequestsToConfirm() {
        ArrayList<FundRequest> fundRequests = admin.getFundRequests();
        if (fundRequests.size() == 0) {
            System.out.println("You have no fund requests");
        } else {
            for (int i = 0; i < fundRequests.size(); i++) {
                System.out.println(i + ". " + fundRequests.get(i).toString());
            }
        }
        System.out.println("Please enter the number of the fund request you want to confirm or -1 to go back");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == -1) {
            showDashboard();
        } else {
            FundRequest fundRequest = fundRequests.get(choice);
            fundRequest.approve();
            fundRequests.remove(fundRequest);
            showDashboard();
        }
    }

    @Override
    public void showProfile() {

    }

    public void showAllUsers() {
        ArrayList<IAllUser> users = LoginDatas.getUsers();
        for (IAllUser user : users) {
            user.showProfile();
            System.out.println("____________________");
        }
        showDashboard();
    }
    public void addAdmin() {
        System.out.println("Please enter the username of the admin you want to add");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.println("Please enter the password of the admin you want to add");
        String password = scanner.nextLine();
        Admin newAdmin = new Admin(username, password, shop);
        shop.admins.add(newAdmin);
        LoginDatas.add(newAdmin);
        System.out.println("Admin added successfully");
        showDashboard();
    }
    public void showTransactionsToConfirm() {
        ArrayList<Transaction> transactions = admin.getTransactionsToConfirm();
        if (transactions.size() == 0) {
            System.out.println("You have no transactions to confirm");
        } else {
            for (int i = 0; i < transactions.size(); i++) {
                System.out.println(i + ". " + transactions.get(i).toString());
            }
        }
        System.out.println("Please enter the number of the transaction you want to confirm or -1 to go back");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == -1) {
            showDashboard();
        } else {
            Transaction transaction = transactions.get(choice);
            transaction.processTransaction();
            transactions.remove(transaction);
            showDashboard();
        }
    }
    public void showCertificationRequests() {
        ArrayList<CertificationRequest> certificationRequests = admin.getCertificationRequests();
        if (certificationRequests.size() == 0) {
            System.out.println("You have no certification requests");
        } else {
            for (int i = 0; i < certificationRequests.size(); i++) {
                System.out.println(i + ". " + certificationRequests.get(i).toString());
            }
        }
        System.out.println("Please enter the number of the certification request you want to confirm or -1 to go back");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == -1) {
            showDashboard();
        } else {
            CertificationRequest certificationRequest = certificationRequests.get(choice);
            certificationRequest.approve();
            certificationRequests.remove(certificationRequest);
            showDashboard();
        }
    }


}
