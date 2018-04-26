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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isBought() {
        return bought;
    }

    public void setBought(boolean bought) {
        this.bought = bought;
    }

}
