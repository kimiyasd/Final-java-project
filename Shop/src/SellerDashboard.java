import java.util.Scanner;

public class SellerDashboard implements IDashboard{

    private Seller seller;
    private OnlineShop shop;

    public SellerDashboard(Seller seller, OnlineShop shop) {
        this.seller = seller;
        this.shop = shop;
    }

    @Override
    public void showDashboard() {
        if (seller.isCertified) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome " + seller.getUsername());
            System.out.println("Your balance is: " + seller.getWallet().getBalance());
            System.out.println("Please choose an option:");
            System.out.println("1. Show your orders");
            System.out.println("2. Show your cart");
            System.out.println("3. Search for a product");
            System.out.println("4. Logout");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    //showOrders();
                    break;
                case "2":
                    //showCart();
                    break;
                case "3":
                    //searchProduct();
                    break;
                case "4":
                    IntroPage.Intro(shop);
                    break;
                default:
                    System.out.println("Invalid choice");
                    showDashboard();
            }
        }
        else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("You are not certified yet");
            System.out.println("Please send your full name and address to the admin for certification");
            System.out.println("Name: ");
            String name = scanner.nextLine();
            System.out.println("Address: ");
            String address = scanner.nextLine();
            CertificationRequest certificationRequest = new CertificationRequest(seller, name, address);
            shop.mainAdmin.addCertificationRequest(certificationRequest);
            System.out.println("Request sent to admin");
            IntroPage.Intro(shop);

        }
    }

    @Override
    public void showProfile() {

    }
}
