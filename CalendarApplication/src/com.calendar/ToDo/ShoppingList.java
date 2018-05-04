package com.calendar.ToDo;

import java.util.ArrayList;
import java.util.List;

public class ShoppingList extends ToDoObject {
    private List<ShoppingItem> items;
    private double totalSum;

    public ShoppingList(String name, String creationDate, String date, String deadline) {
        super(name, creationDate, date, deadline);
        this.items = new ArrayList<>();
        this.totalSum = 0.0;
    }

    public void addItem(ShoppingItem item) {
        items.add(item);
        System.out.printf("Item %s has been added to your shopping list", item.getName());
        System.out.println();
    }


    @Override
    public void markDone() {
        this.setDone(true);

        System.out.println("Bought items: ");
        items.stream()
                .filter(x -> x.isBought())
                .forEach(System.out::println);

        System.out.println("Ignored items: ");
        items.stream()
                .filter(x -> !x.isBought())
                .forEach(System.out::println);

    }

    @Override
    public void view() {
        System.out.println("Shopping list: " + getName());
        printItems();
        getSumOfBoughtItems();
        System.out.println("Total money spent: " + totalSum);
    }

    private void printItems() {
        items.stream().forEach(x -> System.out.println(" - " + x.getName() + ": " + isItemBought(x)));
    }

    private String isItemBought(ShoppingItem item) {
        if (item.isBought()) {
            return "Bought";
        } else {
            return "Ignored";

        }
    }

    private void getSumOfBoughtItems() {
        totalSum = items.stream()
                .filter(x -> x.isBought())
                .mapToDouble(x -> x.getPrice())
                .sum();


    }

    public void markBought(String name) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(name)) {
                items.get(i).setBought(true);
                break;
            }

        }
    }
}
