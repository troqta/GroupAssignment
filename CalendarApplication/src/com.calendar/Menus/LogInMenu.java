package com.calendar.Menus;

import com.calendar.DashBoard;

import java.util.Scanner;

public class LogInMenu extends Menu {
    Scanner in = new Scanner(System.in);

    public LogInMenu(DashBoard dashBoard) {
        super(dashBoard);
    }

    @Override
    public void selectOptions() {
        int option = 0;
        while (option <= 0 || option > 3) {
            printMenu();
            option = in.nextInt();
        }
        switch (option) {
            case 1:
                getDashBoard().logIn();

                break;
            case 2:
                getDashBoard().singUp();
                break;
            case 3:
                System.exit(0);
                break;
        }
    }

    @Override
    public void printMenu() {
        System.out.println("Insert a digit to select menu option:");
        System.out.println("Option 1: Login");
        System.out.println("Option 2: Sing up");
        System.out.println("Option 3: Exit");
    }
}
