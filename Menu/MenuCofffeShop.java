package Menu;


import CafeShopView.CartOrderView;
import CafeShopView.CofeShopView;

import java.util.Scanner;

public class MenuCofffeShop {
    public void menus() {
        System.out.println(" ------------------------ Quán Đêm Mai Cafe ----------------- ");
        System.out.println("| 1. Thêm Sản Phẩm                                           |");
        System.out.println("| 2. Hiển Thị Sản Phẩm                                       |");
        System.out.println("| 3. Sửa Sản Phẩm                                            |");
        System.out.println("| 4. Tìm Kiếm Theo ID Đồ Uống                                |");
        System.out.println("| 5. Tìm Kiếm Theo Name Đồ Uống                              |");
        System.out.println("| 6. Thêm Vào Giỏ Hàng                                       |");
        System.out.println("| 7. Thoát                                                   |");
        System.out.println(" ------------------------------------------------------------ ");
        CofeShopView cofeShopView = new CofeShopView();
        CartOrderView cartOrderView = new CartOrderView();
        int option = 0;

        do {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println(" Chọn Chức Năng : ");
                option = scanner.nextInt();
                scanner.nextLine();
                switch (option) {
                    case 1:
                        cofeShopView.add();
                    case 2:
                        cofeShopView.show();
                        break;
                    case 3:
                        cofeShopView.update();
                        break;
                    case 4:
                        cofeShopView.SearchId();
                        break;
                    case 5:
                        cofeShopView.SearchName();
                        break;
                    case 6:
                        cartOrderView.Menu();
                        break;
                    case 7:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Mời Bạn Nhập Lại");
                }
            } catch (Exception e) {

            }
        } while (option != 7);
        System.out.println("Cảm ơn Các Bạn Đã Ghé Quán");
    }
}
