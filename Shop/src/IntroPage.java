import java.util.Scanner;
public class IntroPage {
    public static void Intro(OnlineShop shop) {
        System.out.println(String.format("Welcome to %s", shop.getName()));
        System.out.println("Please enter your username to login or register");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        Boolean isRegistered = Certification.isRegistered(username);
        if (isRegistered) {
            System.out.println("Welcome back!");
            Boolean loggedIn = Certification.login(username);
            if (loggedIn) {
                System.out.println("You are now logged in");
                IAllUser user = LoginDatas.getUser(username);
                user.getDashboard().showDashboard();
            } else {
                IntroPage.Intro(shop);
            }


        } else {
            System.out.println("You are not registered. Please choose if you're a Seller or a Buyer(S/B)");
            String choice = scanner.nextLine();
            if (choice.equals("S")) {
                System.out.println("Please enter your password to register");
                String password = scanner.nextLine();
                Seller seller = new Seller(username, password, new Wallet(0.0), shop,false);
                System.out.println("You are now registered as a Seller");
                IntroPage.Intro(shop);
            } else if (choice.equals("B")) {
                System.out.println("Please enter your password to register");
                String password = scanner.nextLine();
                User buyer = new User(username, password, new Wallet(0.0),  shop);
                System.out.println("You are now registered as a Buyer");
                IntroPage.Intro(shop);
            } else {
                System.out.println("Invalid choice");
                IntroPage.Intro(shop);
            }

        }
    }

}
