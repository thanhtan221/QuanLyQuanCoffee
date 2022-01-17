package CafeService;

import Utils.CsvUtils;
import com.vn.Oder.CartOrder;
import com.vn.Oder.CoffeeShop;

import java.util.ArrayList;
import java.util.List;

public class CoffeeService implements ICoffeeService {
    List<CoffeeShop> coffeeShops = new ArrayList<>();
    List<CoffeeShop> coffeeshopview = new ArrayList<>();
    public static String path = "data/CoffeeShop.csv";
    public static String getPath = "data/product.csv";

    public CoffeeService() {
        getCoffeeShop();
    }


    @Override
    public List<CoffeeShop> getCoffeeShop() {
        List<CoffeeShop> newCoffeeShop = new ArrayList<>();
        List<String> records = CsvUtils.read(path);
        for (String record : records) {
            newCoffeeShop.add(new CoffeeShop(record));
        }
        return coffeeShops = newCoffeeShop;
    }

    @Override
    public void add(CoffeeShop newCoffeeShop) {
     coffeeShops.add(newCoffeeShop);
     CsvUtils.write(path,coffeeShops);
    }

    @Override
    public void update() {
        CsvUtils.write(path,coffeeShops);

    }

    @Override
    public CoffeeShop getCoffeeShopById(int id) {
        for (CoffeeShop coffeeShop : coffeeShops) {
            if (coffeeShop.getId() == id)
                return coffeeShop;
        }
        return null;
    }

    @Override
    public boolean exist(int id) {
        return getCoffeeShopById(id) != null;
    }

    @Override
    public boolean checkDuplicateName(String name) {
        for (CoffeeShop coffeeShop : coffeeShops) {
            if (coffeeShop.getName().equals(name))
                return true;
        }
        return false;
    }

    @Override
    public boolean checkDuplicateId(int id) {
        for (CoffeeShop coffeeShop : coffeeShops) {
            if (coffeeShop.getId() == id)
                return true;
        }
        return false;
    }
    @Override
    public List<CoffeeShop> coffeeshop1() {
        List<CoffeeShop> newCoffeeShop = new ArrayList<>();
        List<String> records = CsvUtils.read(getPath);
        for (String record : records) {
            newCoffeeShop.add(new CoffeeShop(record));
        }
        return coffeeshopview = newCoffeeShop;

    }

    @Override
    public CoffeeShop getCoffeeShopsById(int id) {
        for (CoffeeShop coffeeShop : coffeeshopview) {
            if (coffeeShop.getId() == id)
                return coffeeShop;
        }
        return null;
    }
    public CoffeeShop getcoffeeShopByName(String name){
        for (CoffeeShop coffeeShop : coffeeshopview){
            if (coffeeShop.getName() == name)
                return coffeeShop;
        }
        return null;
    }

}
