package User;

import java.util.List;

public interface IUser {
    List<User> getUsers();

    User loginAdmin(String username, String password);

    void add(User newUser);

    void update(User newUser);

    boolean exist(int id);

    boolean checkDuplicatePhone(String phone);

    boolean checkDuplicateName(String Name);

    User getUserById(int id);

}
