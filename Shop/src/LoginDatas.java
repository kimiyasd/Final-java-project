import java.util.ArrayList;


public class LoginDatas {
    public static ArrayList<IAllUser> getUsers() {
        return users;
    }

    public static void setUsers(ArrayList<IAllUser> users) {
        LoginDatas.users = users;
    }

    private static ArrayList<IAllUser> users;

    public LoginDatas() {
        users = new ArrayList<>();
    }


    public static void add(IAllUser user) {
        users.add(user);
    }

    public static IAllUser getUser(String username) {
        for (IAllUser u : users) {
                if (u.getUsername().equals(username)) {
                    return u;
            }
        }
        return null;
    }
    public static void add(User user) {
        users.add(user);
    }
}
