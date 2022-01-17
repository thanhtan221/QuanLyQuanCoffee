package com.vn.Oder;

public class CartOrder {
    private int id;
    private String name;
    private int quantity;
    private int price;
    private String address;
    private String city;
    private long total;

    public CartOrder() {
    }

    public CartOrder(String record) {
        String[] arr = record.split(",");
        id = Integer.parseInt(arr[0]);
        name = arr[1];
        price =Integer.parseInt(arr[2]);
        quantity = Integer.parseInt(arr[3]);
        address = arr[4];
        city = arr[5];
        total =Integer.parseInt(arr[6]);
    }

    public CartOrder(int id, String name, int price, int quantity, String address, String city, long total) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.address = address;
        this.city = city;
        this.total = total;
    }

    public int getId() {
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return
               id + "," + name + "," + price + "," + quantity + "," + address + "," + city + "," + total ;
    }


}
