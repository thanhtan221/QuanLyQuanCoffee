package CafeShopView;

import CafeService.CartOrderService;
import Menu.MenuCofffeShop;
import com.vn.Oder.CartOrder;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class CartOrderView {
    CofeShopView cofeShopView = new CofeShopView();
    MenuCofffeShop menuCofffeShop = new MenuCofffeShop();
    private final CartOrderService cartOrderService;
    Scanner scanner = new Scanner(System.in);
    DecimalFormat format = new DecimalFormat("###,###,###" + " vnđ");
    public CartOrderView() {
        cartOrderService = new CartOrderService();
    }

    public void add() {
        cofeShopView.MenuOder();
        cartOrderService.getCartOders();
        System.out.println("Nhập id sản phẩm: ");
        int id = scanner.nextInt();
        CartOrder cartOrder = cartOrderService.getCartOrdersById(id);
        String name = cartOrder.getName();
        System.out.println(" Tên Đồ Uống : " + name);
        cartOrder = cartOrderService.getCartOrdersById(id);
        int price = cartOrder.getPrice();
        System.out.println(" Giá Đồ Uống : " + price);
        System.out.println("Nhập số lượng: ");
        int quantity =scanner.nextInt();
        if (quantity < 0)
            System.out.println(" Bạn không Được Nhập Số âm : Ví Dụ :-1");
        else
        scanner.nextLine();
        System.out.println(" Nhập Địa chỉ : Ví Dụ 58 Phạm thị Liên");
        String address = scanner.nextLine();
        System.out.println("Nhập Thành Phố : Ví Dụ Thành Phố Huế");
        String city = scanner.nextLine();
        int total = quantity * price;
        cartOrder = new CartOrder(id, name, price, quantity, address, city, total);
        cartOrderService.add(cartOrder);
        System.out.println("Bạn đã thêm Coffee thành công\n");

        boolean is = true;
        do {
            System.out.println("Nhấn '1' để thêm đồ uống mới \t|\t '2' để quay lại \t|\t '3' quay lại menu chính \t\t '4' thoát");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    Menu();
                    break;
                case 3:
                    menuCofffeShop.menus();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nhấn không đúng! vui lòng chọn lại");
                    is = false;
            }
        } while (!is);
    }


    public void show() {
        List<CartOrder> cartOrders = cartOrderService.getCartOder();
        long total = 0;
        System.out.println("--------------------------------------------------------------- Hóa Đơn --------------------------------------------------------------------------------------------------------------------------|");
        System.out.printf("%-10s %-30s %-25s %-30s %-40s %-40s %-15s \n", "Id", "Tên Coffee", "Giá Coffee", "Số Lượng ", " Địa Chỉ ", "Thành Phố", "Tổng Giá Tiền");
        System.out.println(" ");
        for (CartOrder cartOrder : cartOrders) {
            System.out.printf("%-10d %-30s %-25s %-30s %-40s %-43s %-15s \n", cartOrder.getId(), cartOrder.getName(),
                    format.format(cartOrder.getPrice()),cartOrder.getQuantity(), cartOrder.getAddress(), cartOrder.getCity(), format.format(cartOrder.getTotal()));
            total += cartOrder.getTotal();

        }
        System.out.println("                                                                                                                                                                           " + " Tổng Tiền : " + format.format(total));
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|\n");
    }


    public void update() {
        show();
        System.out.println(" Nhập Id Sản Phẩm Cần Sửa : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        CartOrder cartOrder = cartOrderService.getCartOrderById(id);
        if (cartOrderService.checkDuplicateId(id)) {
            System.out.println("---------------------");
            System.out.println("| 1.Sửa Tên Đồ Uống |");
            System.out.println("| 2.Sửa Số Lượng    |");
            System.out.println("| 3.Sửa Địa chỉ     |");
            System.out.println("| 4.Sửa Thành Phố   |");
            System.out.println("| 5.Quay Lại Menu   |");
            System.out.println("---------------------");
            System.out.println(" Chọn Chức Năng : ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Nhập Tên Đồ Uống Bạn Muốn Sữa ");
                    cofeShopView.MenuOder();
                    String name = scanner.nextLine();
                    cartOrder.setName(name);
                    cartOrderService.update();
                    System.out.println("Bạn Đã Đổi Tên Đồ Uống Thành Công ");
                    break;
                case 2:
                    System.out.println("Nhập Số Lượng Bạn Muốn Sữa ");
                    cofeShopView.MenuOder();
                    int quantity = scanner.nextInt();
                    cartOrder.setQuantity(quantity);
                    cartOrderService.update();
                    System.out.println("Bạn Đã Đổi Số Lượng Đồ Uống Thành Công ");
                    break;
                case 3:
                    System.out.println(" Nhập Địa Chỉ Muốn đổi :");
                    System.out.println("Ví Dụ : 58 Phạm Thị Liên ");
                    String address = scanner.nextLine();
                    cartOrder.setAddress(address);
                    cartOrderService.update();
                    System.out.println(" Bạn Đã Đổi Giá Thành Công ");
                    break;
                case 4:
                    System.out.println(" Nhập Thành Phố Muốn Đổi ");
                    System.out.println(" Ví Dụ : Thành Phố Huế");
                    String city = scanner.nextLine();
                    cartOrder.setCity(city);
                    cartOrderService.update();
                    System.out.println(" Bạn Đã Đổi Giá Thành Công  ");
                    break;
                case 5:
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
                        Menu();
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

    public void Menu() {
        System.out.println("---------------------- Giỏ Hàng Quán cafe Đêm Mai --------------------");
        System.out.println("| 1. Thêm Vào Giỏ Hàng                                               |");
        System.out.println("| 2. Hiển Thị Giỏ Hàng                                               |");
        System.out.println("| 3. Sửa Giỏ Hàng                                                    |");
        System.out.println("| 4. Tìm Kiếm Id                                                     |");
        System.out.println("| 5. Quay Lại Menu                                                   |");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Chọn Chức Năng : ");
        int input = scanner.nextInt();
        scanner.nextLine();
        switch (input) {
            case 1:
                add();
                break;
            case 2:
                show();
                break;
            case 3:
                update();
                break;
            case 4:
                SearchId();
                break;
            case 6:
                menuCofffeShop.menus();
                break;
            default:
                System.out.println(" Nhấn Không Đúng ! Vui Lòng Chọn Lại");
        }
        boolean is = true;
        do {
            System.out.println("Nhấn '1' để thêm đồ uống mới \t|\t '2' để quay lại Menu  \t|\t '3' để thoát");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    Menu();
                    break;
                case 3:
                    System.exit(0);
                    menuCofffeShop.menus();
                default:
                    System.out.println("Mời Bạn Nhập Lại");
                    is = false;
            }
        } while (!is);
    }

    public void SearchId() {
        System.out.println(" Nhập Id Bạn Muốn Tìm :");
        int id = scanner.nextInt();
        for (CartOrder cartOrder : cartOrderService.getCartOder()) {
            if (cartOrder.equals(cartOrderService.getCartOrderById(id)))
                System.out.println(cartOrder);
        }
        System.out.println("Không Tìm Thấy "+ id);

    }

}
