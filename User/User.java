package User;

import com.vn.Oder.Role;

public class User {
    private int id;
    private String Name;
    private String password;
    private String Phone;
    private Role role;

    public User() {
    }

    public User(String account) {
        String[] strings = account.split(",");
        this.id =Integer.parseInt(strings[0]);
        this.Name = strings[1];
        this.password = strings[2];
        this.Phone = strings[3];
        this.role = Role.fromValue((strings[4]));
    }

    public User(int id, String name, String password, String phone, Role role) {
        this.id = id;
        Name = name;
        this.password = password;
        Phone = phone;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return  +
                 id +"," +
                 Name + "," +
               password  + "," +
                 Phone +  "," +
                 role ;
    }
}
