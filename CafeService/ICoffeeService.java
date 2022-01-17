package CafeService;

import com.vn.Oder.CoffeeShop;

import java.util.List;

public interface ICoffeeService {
    List<CoffeeShop> getCoffeeShop();

    void add(CoffeeShop newCoffeeShop);

    void update();

    CoffeeShop getCoffeeShopById(int id);

    boolean exist(int id);

    boolean checkDuplicateName(String name);

    boolean checkDuplicateId(int id);

    List<CoffeeShop> coffeeshop1();
    CoffeeShop getCoffeeShopsById(int id);
}
