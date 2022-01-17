package CafeService;

import com.vn.Oder.CartOrder;

import java.util.List;

public interface ICartOrderService {
    List<CartOrder> getCartOder();

    void add(CartOrder newCartOrder);

    void update();

    CartOrder getCartOrderById(int id);

    boolean exist(int id);
    boolean checkDuplicateName(String name);

    boolean checkDuplicateId(int id);
    CartOrder getCartOrdersById(int id);

}
