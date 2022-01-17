package Menu;

import CafeShopView.UserView;

import java.util.Scanner;

public class MenuUser {
    public void menuuser() {
        System.out.println("---------- User Manager ---------");
        System.out.println("| 1. Thêm người dùng            |");
        System.out.println("| 2. Sửa thông tin người dùng   |");
        System.out.println("| 3. Hiện Danh sách người dùng  |");
        System.out.println("| 4. Hiện Menu Quán             |");
        System.out.println("---------------------------------");
        Scanner scanner = new Scanner(System.in);
        UserView userView = new UserView();
        MenuCofffeShop menuCofffeShop = new MenuCofffeShop();

        int number = 0;

        do {
            try {
                System.out.println("\n Chọn chức năng ");
                number=scanner.nextInt();
                switch (number) {
                    case 1:
                        userView.addUser();
                        break;
                    case 2:
                        userView.updateUser();
                        break;
                    case 3:
                        userView.show();
                        break;
                    case 4:
                        menuCofffeShop.menus();
                        break;
                    default:
                        System.out.println("Chọn chức năng không đúng! Vui lòng chọn lại");
                        menuuser();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (number!=5);
            System.out.println("cảm ơn các bạn đã ghé quán");



    }
}
