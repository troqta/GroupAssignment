package com.calendar.Menus;

import com.calendar.DashBoard;
import com.calendar.ToDo.ShoppingItem;
import com.calendar.ToDo.ShoppingList;
import com.calendar.ToDo.TaskList;

import java.util.Scanner;

public class ViewShoppingListMenu extends Menu {
    private ShoppingList shoppingList;

    Scanner in = new Scanner(System.in);

    public ViewShoppingListMenu(DashBoard dashBoard, ShoppingList shoppingList) {
        super(dashBoard);
        this.shoppingList = shoppingList;
    }

    @Override
    public void selectOptions() {
        int option = 0;
        while (option <= 0 || option > 5) {
            printMenu();
            option = in.nextInt();
        }
        switch (option) {
            case 1:
                getDashBoard().addShoppingItem(shoppingList);
                new ViewShoppingListMenu(getDashBoard(),shoppingList).selectOptions();
                break;
            case 2:
                new EditMenu(getDashBoard(), shoppingList).selectOptions();
                break;
            case 3:
                getDashBoard().getCurrentUser().delete(shoppingList);
                System.out.println(shoppingList.getName() + " deleted successfully");
                new ViewShoppingListMenu(getDashBoard(),shoppingList).selectOptions();
                break;
            case 4:
                shoppingList.markDone();
                break;
            case 5:
                new MainMenu(getDashBoard()).selectOptions();
                break;
        }
    }

    @Override
    public void printMenu() {
        System.out.println("Insert a digit to select menu option:");
        System.out.println("Option 1: Add new item");
        System.out.println("Option 2: Edit shopping list");
        System.out.println("Option 3: Delete shopping list");
        System.out.println("Option 4: Mark as done");
        System.out.println("Option 5: Back to Main menu");
    }
}
