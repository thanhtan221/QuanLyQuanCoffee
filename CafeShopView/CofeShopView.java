package CafeShopView;


import CafeService.CoffeeService;
import Menu.MenuCofffeShop;
import com.vn.Oder.CoffeeShop;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class CofeShopView {
    private final CoffeeService coffeeService;
    private final Scanner scanner;
    MenuCofffeShop menuCofffeShop = new MenuCofffeShop();
    DecimalFormat format = new DecimalFormat("###,###,###" + " đ");


    public CofeShopView() {
        coffeeService = new CoffeeService();

        scanner = new Scanner(System.in);
    }

    public void MenuOder() {
        System.out.println("--------------------------- Cafe Đêm Mai -------------------------");
        System.out.println(" ID               Tên Đồ Uống                       Giá");
        System.out.println(" 1                Cafe Đen                         8k        ");
        System.out.println(" 2                Cafe sữa                         10k       ");
        System.out.println(" 3                Cafe Muối                        15k       ");
        System.out.println(" 4                Nước Ép Cóc                      15k       ");
        System.out.println(" 5                Nước Ép Xoài                     15k       ");
        System.out.println(" 6                Nước Ép ổi                       15k       ");
        System.out.println(" 7                Nước Chanh                       12k       ");
        System.out.println(" 8                Cafe Đá Xay + Kem                35k       ");
        System.out.println(" 9                socola Đá Xay + Kem              35k       ");
        System.out.println(" 10               Soda Mix Dây Tây                 30k       ");
        System.out.println(" 11               Soda Mix Đào                     30k       ");
        System.out.println(" 12               Espresso Sữa                     15k       ");
        System.out.println(" 13               Espresso Đen                     14k       ");
        System.out.println(" 14               Soda Việt Quất                   25k       ");
        System.out.println(" 15               Soda Xoài                        25k       ");
        System.out.println(" 16               Soda Dâu                         25k       ");
        System.out.println(" 17               Soda Chanh Dây                   25k       ");
        System.out.println(" 18               Trà Gừng                         20k       ");
        System.out.println(" 19               Trà Gừng Mực Ong                 25k       ");
        System.out.println(" 20               Trà Liptong                      30k       ");
        System.out.println(" 21               Trà Đào                          15k       ");
        System.out.println(" 22               Trà Sữa Truyền thống             15k       ");
        System.out.println("--------------------------- Cảm Ơn Các Bạn Đã Ghé ----------------");
    }

    public void add() {
        MenuOder();
        coffeeService.coffeeshop1();
        System.out.println("Nhập id sản phẩm: ");
        int id = scanner.nextInt();
        CoffeeShop coffeeShop = coffeeService.getCoffeeShopsById(id);
        String name = coffeeShop.getName();
        System.out.println("Tên Đồ Uống : " + name);
        coffeeShop = coffeeService.getCoffeeShopsById(id);
        int price = coffeeShop.getPrice();
        System.out.println(" Giá Đồ Uống : " + price);
        System.out.println("Nhập số lượng: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        int total = price * quantity;
        coffeeShop = new CoffeeShop(id, name, price, quantity, total);
        coffeeService.add(coffeeShop);
        System.out.println("Bạn đã thêm Coffee thành công\n");
        boolean is = true;
        do {
            System.out.println("Nhấn '1' để thêm đồ uống mới \t|\t '2' để quay lại \t|\t '3' để thoát");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    menuCofffeShop.menus();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nhấn không đúng! vui lòng chọn lại");
                    is = false;
            }
        } while (!is);
    }

    public void show() {
        long total = 0;
        List<CoffeeShop> coffeeShop = coffeeService.getCoffeeShop();
        System.out.println("-----------------------------------------DANH SÁCH CAFFE----------------------------------------------------------------------------|");
        System.out.printf("%-10s %-30s %-25s %-25s %-40s \n", "Id", "Tên Coffee", "Số lượng", "Giá Coffee ", "Tổng Số Tiền");
        System.out.println(" ");
        for (CoffeeShop coffeeShop1 : coffeeShop) {
            System.out.printf("%-10d %-33s %-25d %-25s %-38s \n", coffeeShop1.getId(), coffeeShop1.getName(),
                    coffeeShop1.getQuantity(), format.format(coffeeShop1.getPrice()), format.format(coffeeShop1.getTotal()));
            total += coffeeShop1.getTotal();
        }
        System.out.println("                                                                                     " + "Tổng Tiền : " + format.format(total));
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------|\n");
    }

    public void update() {
        show();
        System.out.println(" Nhập Id Sản Phẩm Cần Sửa : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        CoffeeShop coffeeShop = coffeeService.getCoffeeShopById(id);
        if (coffeeService.checkDuplicateId(id)) {
            System.out.println("--------------------");
            System.out.println("| 1.Sửa Tên Đồ Uống ");
            System.out.println("| 2.Sửa Số Lượng    ");
            System.out.println("| 3.Quay Lại Menu   ");
            System.out.println(" Chọn Chức Năng : ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Nhập Tên Đồ Uống Bạn Muốn Sữa ");
                    MenuOder();
                    String name = scanner.nextLine();
                    coffeeShop.setName(name);
                    coffeeService.update();
                    System.out.println("Bạn Đã Đổi Tên Đồ Uống Thành Công ");
                    break;
                case 2:
                    System.out.println("Nhập Số Lượng Bạn Muốn Sữa ");
                    MenuOder();
                    int quantity = scanner.nextInt();
                    coffeeShop.setQuantity(quantity);
                    coffeeService.update();
                    System.out.println("Bạn Đã Đổi Số Lượng Đồ Uống Thành Công ");
                    break;
                case 3:
                    menuCofffeShop.menus();
                default:
                    System.out.println("Chọn Chức Năng Không Đúng Vui Lòng Chọn Lại");
                    update();
            }
            boolean is = true;
            do {
                System.out.println("Nhấn '1' để sửa tiếp \t|\t '2' để quay lại \t|\t '3' để thoát chương trình");
                int input = scanner.nextInt();
                scanner.nextLine();
                switch (input) {
                    case 1:
                        update();
                        break;
                    case 2:
                        menuCofffeShop.menus();
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.out.println(" Nhấn Không Đúng ! Vui Lòng Chọn Lại ");
                        is = false;

                }
            } while (!is);
        } else {
            System.out.println("Không tìm thấy id! Vui lòng nhập lại");
            update();
        }

    }

    public void SearchId() {
        System.out.println(" Nhập Id Bạn Muốn Tìm :");
        int id = scanner.nextInt();
        for (CoffeeShop coffeeShop : coffeeService.getCoffeeShop()) {
            if (coffeeShop.equals(coffeeService.getCoffeeShopById(id))) {
                System.out.println(coffeeShop);
            }
        }
        System.out.println("không tìm thấy " + id);
    }
    public void SearchName(){
        String name = scanner.nextLine();
        for (CoffeeShop coffeeShop : coffeeService.getCoffeeShop()){
            if (coffeeShop.equals(coffeeService.getcoffeeShopByName(name)));
            System.out.println(coffeeShop);
        }
    }
}
