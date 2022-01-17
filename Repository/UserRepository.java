package Repository;

import User.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public static List<User> userList = new ArrayList<>();

    public static void addUser(User user) {
        userList.add(user);
    }
    public static User getByName(String name) {
        for (User user : userList) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }
    public static boolean exist(User user) {
        for (User user1: userList) {
            if (user1.equals(user)) {
                return true;
            }
        }
        return false;
    }
}
