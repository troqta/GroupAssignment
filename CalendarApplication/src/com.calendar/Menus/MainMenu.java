package com.calendar.Menus;

import java.util.Scanner;

public class MainMenu extends Menu{
    Scanner in = new Scanner(System.in);
    public void selectOptions(){
        int option = 0;
        while (option <= 0 || option > 3){
            printMenu();
            option = in.nextInt();
        }
        switch (option){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9: System.exit(0);
        }
    }
    @Override
    public void printMenu() {
        System.out.println("Insert a digit to select menu option:");
        System.out.println("Option 1: Show calendar");
        System.out.println("Option 2: Display chosen date");
        System.out.println("Option 3: View chosen calendar object");
        System.out.println("Option 4: Create Meeting");
        System.out.println("Option 5: Create Appointment ");
        System.out.println("Option 6: Create Shopping List");
        System.out.println("Option 7: Create Task List");
        System.out.println("Option 8: Log out");
        System.out.println("Option 9: Exit");
    }
}
