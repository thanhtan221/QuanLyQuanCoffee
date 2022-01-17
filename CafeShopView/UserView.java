package CafeShopView;

import CafeService.UserService;

import Menu.MenuCofffeShop;
import Menu.MenuUser;
import User.IUser;
import User.User;
import Utils.ValidateUtils;
import com.vn.Oder.Role;

import java.util.List;
import java.util.Scanner;

public class UserView {
    private final IUser iUser;
    Scanner scanner = new Scanner(System.in);
    UserService userService = new UserService();
    MenuUser menuUser = new MenuUser();
    User user = new User();

    public UserView() {
        iUser = new UserService();
    }

    public void loginAdmin() {
        System.out.println("--------- Đăng Nhập Hệ Thống ----------");
        System.out.println(" Đăng Nhập : ");
        String acccount = scanner.nextLine();
        System.out.println(" Mật Khẩu : ");
        String password = scanner.nextLine();
        if (userService.loginAdmin(acccount, password) == null) {
            System.out.println(" Tài Khoản Không Hợp Lệ ");
        } else {
            System.out.println("Bạn Đã Đăng Nhập Thành Công ");
            menuUser.menuuser();
        }
    }
    public void loginUser() {
        System.out.println("--------- Đăng Nhập Hệ Thống ----------");
        System.out.println(" Đăng Nhập ");
        String acccount = scanner.nextLine();
        System.out.println(" Mật Khẩu");
        String password = scanner.nextLine();
        if (userService.loginUser(acccount, password) == null) {
            System.out.println(" Tài Khoản Không Hợp Lệ ");
        } else {
            System.out.println("Bạn Đã Đăng Nhập Thành Công ");
            MenuCofffeShop menuCofffeShop = new MenuCofffeShop();
            menuCofffeShop.menus();
        }
    }

    public void addUser() {
        try {
            System.out.println("Nhập id");
            int id = scanner.nextInt();
            scanner.nextLine();
            if (userService.exist(id)) {
                System.out.println("Id này đã tồn tại. Vui lòng nhập id khác!");
                addUser();
            } else {
                System.out.println("Nhập Tài Khoản");
                String account = scanner.nextLine();
                while (userService.checkDuplicateName(account)) {
                    System.out.println("account này đã tồn tại. Vui lòng nhập lại");
                }
                System.out.println("Nhập Mật Khẩu");
                String password = scanner.nextLine();
                while (!ValidateUtils.isPasswordValid(password)) {
                    System.out.println("Mật khẩu yếu! Vui lòng nhập lại ");
                    password = scanner.nextLine();
                }
                System.out.println("Nhập số điện thoại (vd: 0345129876): ");
                String phone = scanner.nextLine();
                while (!ValidateUtils.isPhoneValid(phone)) {
                    System.out.println("Số " + phone + " của bạn không đúng định dạng. Vui lòng nhập lại! " + "(Số điện thoại bao gồm 10 số và bắt đầu là số 0)");
                    System.out.println("Nhập số điện thoại (vd: 0345129876)");
                    phone = scanner.nextLine();
                }
                while (userService.checkDuplicatePhone(phone)) {
                    System.out.println("Số điện thoại này đã tồn tại! vui lòng kiểm tra lại!");
                    System.out.println("Nhập số điện thoại (vd: 0345129876)");
                    phone = scanner.nextLine();
                }
                User user = new User(id, account, password, phone,Role.USER);
                setRole(user);
                userService.add(user);
                System.out.println("Đã thêm thành công!");
            }
            boolean check = true;
            do {
                System.out.println("Nhấn '1' để thêm tiếp người dùng \t|\t '2' để quay lại \t|\t '3' để thoát");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        addUser();
                        break;
                    case 2:
                        AdminView();
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Nhấn không đúng! vui lòng chọn lại");
                        check = false;
                }
            } while (!check);
        } catch (Exception e) {
            System.out.println("Nhập Sai Vui Lòng nhập Lại");
        }
    }

    public void setRole(User user) {
        System.out.println("= = SET ROLE = =");
        System.out.println("∥   1. USER    ∥");
        System.out.println("∥   2. ADMIN   ∥");
        System.out.println("= = = =  = = = = ");
        System.out.println("Chọn Role: ");
        int chido = scanner.nextInt();
        switch (chido) {
            case 1:
                user.setRole(Role.USER);
                break;
            case 2:
                user.setRole(Role.ADMIN);
                break;
            default:
                System.out.println("Nhập không đúng! Vui lòng nhập lại");
                setRole(user);
        }
    }

    public void show() {
        System.out.println("----------------------------------------- DANH SÁCH NGƯỜI DÙNG--------------------------------------- ");
        System.out.printf("%-5s %-22s %-15s %-22s %-20s  \n", "Id", "Tài Khoản", "Mật Khẩu", "Số Điện Thoại", "Người dùng");
        List<User> users = userService.getUsers();
        for (User user : users) {
            System.out.printf("%-5d %-22s %-15s %-22s %-20s \n", user.getId(), user.getName(), user.getPassword(), user.getPhone(), user.getRole());
        }
        System.out.println("-----------------------------------------------------------------------------------------------------  ");
        System.out.println(" ");
    }

    public void updateUser() {
        try {
            show();
            userService.getUsers();
            System.out.println("Nhập Id Muốn Đổi :  ");
            int id = scanner.nextInt();
            if (userService.exist(id)) {
                System.out.println("----------- Sửa User --------");
                System.out.println("| 1. Đổi Tên                |");
                System.out.println("| 2. Sửa Mật Khẩu           |");
                System.out.println("| 3. Sửa Số Điện Thoại      |");
                System.out.println("| 4. Quay Lại Menu          |");
                System.out.println("-----------------------------");
                System.out.println("Vui Lòng Chọn Chức Năng : ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                user.setId(id);
                switch (choice) {
                    case 1:
                        System.out.println("Nhập Tên Bạn Muốn Sửa : ");
                        String account = scanner.nextLine();
                        while (userService.checkDuplicateName(account)){
                            System.out.println(" Tên Này Đã Tồn Tại ");
                            account=scanner.nextLine();
                        }
                        user.setName(account);
                        userService.update(user);
                        System.out.println(" Bạn Thay Đổi Thành Công");
                        break;
                    case 2:
                        System.out.println("Nhập Mật Khẩu Bạn muốn đổi :");
                        String password = scanner.nextLine();
                        user.setPassword(password);
                        userService.update(user);
                        System.out.println("Bạn Thay Đổi Thành Công ");
                        break;
                    case 3:
                        System.out.println("Nhập số điện thoại mà bạn muốn đổi");
                        String phone1 = scanner.nextLine();
                        while (!ValidateUtils.isPhoneValid(phone1)) {
                            System.out.println("Số " + phone1 + " của bạn không đúng. Vui lòng nhập lại! " + "(Số điện thoại bao gồm 10 số và bắt đầu là số 0)");
                            System.out.println("Nhập số điện thoại (vd: 0312502789)");
                            phone1 = scanner.nextLine();
                        }
                        while (userService.checkDuplicatePhone(phone1)) {
                            System.out.println("Số này đã tồn tại! Mời bạn nhập lại");
                            phone1 = scanner.nextLine();
                        }
                        user.setPhone(phone1);
                        userService.update(user);
                        System.out.println("Bạn đã đổi số điện thoại thành công");
                        break;
                    case 4:
                        menuUser.menuuser();
                    default:
                        System.out.println("Chọn Chức năng không đúng Vui Lòng chọn Lại");
                        updateUser();
                }
                boolean is = true;
                do {
                    System.out.println("Nhấn '1' để sửa tiếp \t|\t '2' để quay lại\t|\t '3' để thoát chương trình");
                    int choi = scanner.nextInt();
                    scanner.nextLine();
                    switch (choi) {
                        case 1:
                            updateUser();
                            break;
                        case 2:
                            menuUser.menuuser();
                            break;
                        case 3:
                            System.exit(0);
                        default:
                            System.out.println(" Không Đúng Vui Lòng Chọn Lại ");
                            is = false;
                    }
                } while (!is);

            } else {
                System.out.println("Không tìm thấy id  Vui lòng nhập lại");
                updateUser();
            }
        } catch (Exception e) {
            System.out.println("Nhập sai! vui lòng nhập lại");
        }
    }
    public void AdminView(){
        System.out.println("--------------- Quán Cafe Đêm Mai ------------- ");
        System.out.println("| 1. Login Admin                              | ");
        System.out.println("| 2. Login User                               | ");
        System.out.println("| 3. Registration                             | ");
        System.out.println("| 4. Thoát Chương Trình                       | ");
        System.out.println("------------------------------------------------");
        System.out.print(" Chọn Chức Năng :  ");
        int choice= scanner.nextInt();
        scanner.nextLine();
        switch (choice){
            case 1:
                loginAdmin();
                break;
            case 2:
                loginUser();
                break;
            case 3:
                addUser();
                break;
            case 4:
                System.exit(0);
            default:
                System.out.println("Mời Bạn Nhập Lại");

        }
    }
}
