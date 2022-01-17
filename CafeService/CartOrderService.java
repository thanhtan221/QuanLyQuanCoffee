package CafeService;

import com.vn.Oder.CartOrder;
import Utils.CsvUtils;

import java.util.ArrayList;
import java.util.List;

public class CartOrderService implements ICartOrderService {
    List<CartOrder> cartOrderList = new ArrayList<>();
    List<CartOrder> cartOrderList1 = new ArrayList<>();

    public final static String path = "data/CartOrder.csv";
    public static String getPath = "data/BuyProduct.csv";

    public CartOrderService() {
        cartOrderList = getCartOder();
    }

    @Override
    public List<CartOrder> getCartOder() {
        List<CartOrder> cartOrders = new ArrayList<>();
        List<String> records = CsvUtils.read(path);
        for (String record : records) {
            cartOrders.add(new CartOrder(record));
        }
        return cartOrderList = cartOrders;
    }

    @Override
    public void add(CartOrder newCartOrder) {
        cartOrderList.add(newCartOrder);
        CsvUtils.write(path, cartOrderList);
    }

    @Override
    public void update() {
        CsvUtils.write(path, cartOrderList);

    }

    @Override
    public CartOrder getCartOrderById(int id) {
        for (CartOrder cartOrder : cartOrderList) {
            if (cartOrder.getId() == id)
                return cartOrder;
        }
        return null;
    }

    @Override
    public boolean exist(int id) {
        return getCartOrderById(id) != null;
    }

    @Override
    public boolean checkDuplicateName(String name) {
        for (CartOrder cartOrder : cartOrderList) {
            if (cartOrder.getName().equals(name))
                return true;
        }
        return false;
    }

    @Override
    public boolean checkDuplicateId(int id) {
        for (CartOrder cartOrder : cartOrderList) {
            if (cartOrder.getId() == id)
                return true;
        }
        return false;
    }

    @Override
    public CartOrder getCartOrdersById(int id) {
        for (CartOrder cartOrder : cartOrderList1) {
            if (cartOrder.getId() == id)
                return cartOrder;
        }
        return null;
    }

    public List<CartOrder> getCartOders() {
        List<CartOrder> cartOrders = new ArrayList<>();
        List<String> records = CsvUtils.read(getPath);
        for (String record : records) {
            cartOrders.add(new CartOrder(record));
        }
        return cartOrderList1 = cartOrders;
    }

    public CartOrder getCartOrderByName(String name) {
        for (CartOrder cartOrder : cartOrderList) {
            if (cartOrder.getName() == name)
                return cartOrder;
        }
        return null;
    }
}