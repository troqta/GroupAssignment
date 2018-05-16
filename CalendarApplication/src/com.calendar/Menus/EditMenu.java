package com.calendar.Menus;

import com.calendar.CalendarObject;
import com.calendar.DashBoard;
import com.calendar.Event.Appointment;

import java.util.Scanner;

public class EditMenu extends  Menu{
    private CalendarObject object;

    private Scanner in = new Scanner(System.in);

    EditMenu(DashBoard dashBoard, CalendarObject object) {
        super(dashBoard);
        this.object = object;
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
                getDashBoard().editName(object);
                selectOptions();
                break;
            case 2:
                getDashBoard().changeDate(object);
                selectOptions();
                break;
            case 3:
                new MainMenu(getDashBoard()).selectOptions();
                break;
        }
    }

    @Override
    public void printMenu() {
        System.out.println("Insert a digit to select menu option:");
        System.out.println("Option 1: Edit name");
        System.out.println("Option 2: Edit date");
        System.out.println("Option 3: Main menu");
    }
}
