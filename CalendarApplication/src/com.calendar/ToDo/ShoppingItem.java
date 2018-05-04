package com.calendar.ToDo;

public class ShoppingItem {
    private String name;
    private int quantity;
    private double price;
    private boolean bought;

    public ShoppingItem(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.bought = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    double getPrice() {
        return price;
    }

    boolean isBought() {
        return bought;
    }

    void setBought(boolean bought) {
        this.bought = bought;
    }

}
