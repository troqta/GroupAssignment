package com.calendar.Menus;

import com.calendar.DashBoard;
import com.calendar.Event.Appointment;

import java.util.Scanner;

public class ViewAppointmentMenu extends Menu{
    private Appointment appointment;

    Scanner in = new Scanner(System.in);

    public ViewAppointmentMenu(DashBoard dashBoard, Appointment appointment) {
        super(dashBoard);
        this.appointment = appointment;
    }

    @Override
    public void selectOptions() {
        int option = 0;
        while (option <= 0 || option > 4) {
            printMenu();
            option = in.nextInt();
        }
        switch (option) {
            case 1:
                appointment.attend();
                new ViewAppointmentMenu(getDashBoard(),appointment).selectOptions();
                break;
            case 2:
                new EditMenu(getDashBoard(), appointment).selectOptions();
                break;
            case 3:
                getDashBoard().getCurrentUser().delete(appointment);
                System.out.println(appointment.getName() + " deleted successfully");
                new ViewAppointmentMenu(getDashBoard(),appointment).selectOptions();
                break;
            case 4:
                appointment.getReminder();
                break;
            case 5:
                new MainMenu(getDashBoard()).selectOptions();
                break;
        }
    }

    @Override
    public void printMenu() {
        System.out.println("Insert a digit to select menu option:");
        System.out.println("Option 1: Attend appointment");
        System.out.println("Option 2: Edit appointment");
        System.out.println("Option 3: Delete appointment");
        System.out.println("Option 4: Get reminder");
        System.out.println("Option 5: Back to Main menu");
    }
}
