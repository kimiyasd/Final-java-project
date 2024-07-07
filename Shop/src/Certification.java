import java.util.Scanner;
public class Certification {
    public static Boolean isRegistered(String username) {
        System.out.println("Checking if user is registered");
        IAllUser user = LoginDatas.getUser(username);
        if (user != null) {
            return true;
        } else {
            return false;
        }
    }
    public static Boolean login(String username) {
        IAllUser user = LoginDatas.getUser(username);
        if (user != null) {
            System.out.println("Please enter your password to login");
            Scanner scanner = new Scanner(System.in);
            String password = scanner.nextLine();
            if (user.getPassword().equals(password)) {
                return true;
            } else {
                System.out.println("Incorrect password, press 1 to try again or 2 to cancel");
                String choice = scanner.nextLine();
                if (choice.equals("1")) {
                    return login(username);
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }

}
