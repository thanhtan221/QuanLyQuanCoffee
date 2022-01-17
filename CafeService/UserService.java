package CafeService;

import User.IUser;
import User.User;
import Utils.CsvUtils;
import com.vn.Oder.Role;


import java.util.ArrayList;
import java.util.List;


public class UserService implements IUser {
    public final static String path = "data/User.csv";
    @Override
    public List<User> getUsers()  {
        List<User> newUsers = new ArrayList<>();
        List<String> records = CsvUtils.read(path);
        for (String record : records) {
            newUsers.add(new User(record));
        }
        return newUsers;
    }

    @Override
    public User loginAdmin(String username, String password) {
        List<User> users = getUsers();
        for (User user : users) {
            if (user.getName().equals(username) && user.getPassword().equals(password)
                    && user.getRole().equals(Role.ADMIN)) {
                return user;
            }
        }
        return null;
    }
public User loginUser(String name , String Password){
        List<User> users = getUsers();
        for (User user : users){
            if (user.getName().equals(name)&& user.getPassword().equals(Password) && user.getRole().equals(Role.USER)){
                return user;
            }
        }
        return  null;
}

    @Override
    public boolean exist(int id) {
        return getUserById(id) != null;
    }

    @Override
    public boolean checkDuplicatePhone(String phone) {
        List<User> users = getUsers();
        for (User user : users) {
            if (user.getPhone().equals(phone))
                return true;
        }
        return false;
    }

    @Override
    public boolean checkDuplicateName(String Name) {
        List<User> users = getUsers();
        for (User user : users) {
            if (user.getName().equals(Name))
                return true;
        }
        return false;
    }



    @Override
    public User getUserById(int id) {
        List<User> users = getUsers();
        for (User user : users) {
            if (user.getId() == id)
                return user;
        }
        return null;
    }

    @Override
    public void update(User newUser) {
        List<User> users = getUsers();
        for (User user : users) {
            if (user.getId() == newUser.getId() ) {
                if (newUser.getName() != null )
                    user.setName(newUser.getName());
                if (newUser.getPassword() != null)
                    user.setPassword(newUser.getPassword());
                if (newUser.getPhone() != null)
                    user.setPhone(newUser.getPhone());
                CsvUtils.write(path, users);
                break;
            }
        }
    }

    @Override
    public void add(User newUser) {
        List<User> users = getUsers();
        users.add(newUser);
        CsvUtils.write(path, users);

    }
}
