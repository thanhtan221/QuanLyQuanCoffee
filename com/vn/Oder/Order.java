package com.vn.Oder;

public class Order {
    private long id;
    private String name;
    private double price;
    private int quantity;
    private double total = quantity*price;

    public Order(long id, String name, double price, int quantity, double total) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
    }

    public Order() {
    }
    public Order(String record) {
        String[] fields = record.split(",");
        id = Long.parseLong(fields[0]);
        name = fields[1];
        price = Double.parseDouble(fields[2]);
        quantity = Integer.parseInt(fields[3]);
        total = Double.parseDouble(fields[4]);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }




    @Override
    public String toString() {
        return id + "," + price + "," + quantity + "," + name + "," +total;
    }

}
