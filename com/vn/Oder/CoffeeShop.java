package com.vn.Oder;

public class CoffeeShop {
    private int id;
    private String name;
    private int price;
    private int quantity;
  private int total;
    public CoffeeShop(int id, String name, int price, int quantity , int total) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
    }

    public CoffeeShop() {
    }

    public CoffeeShop(String record) {
        String[] arr = record.split(",");
        id=Integer.parseInt(arr[0]);
        name = arr[1];
        price = Integer.parseInt(arr[2]);
        quantity = Integer.parseInt(arr[3]);
        total =Integer.parseInt(arr[4]);
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + price + "," + quantity + "," + total ;
    }


}
