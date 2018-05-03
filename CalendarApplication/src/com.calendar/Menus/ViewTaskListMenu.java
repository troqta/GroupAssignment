package com.calendar.Menus;

import com.calendar.DashBoard;
import com.calendar.Event.Appointment;
import com.calendar.ToDo.TaskList;

import java.util.Scanner;

public class ViewTaskListMenu extends Menu {

    private TaskList taskList;

    Scanner in = new Scanner(System.in);

    public ViewTaskListMenu(DashBoard dashBoard, TaskList taskList) {
        super(dashBoard);
        this.taskList = taskList;
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
                getDashBoard().addTask(taskList);
                new ViewTaskListMenu(getDashBoard(), taskList).selectOptions();
                break;
            case 2:
                new EditMenu(getDashBoard(), taskList).selectOptions();
                break;
            case 3:
                getDashBoard().getCurrentUser().delete(taskList);
                System.out.println(taskList.getName() + " deleted successfully");
                new ViewTaskListMenu(getDashBoard(), taskList).selectOptions();
                break;
            case 4:
                taskList.markDone();
                break;
            case 5:
                new MainMenu(getDashBoard()).selectOptions();
                break;
        }
    }

    @Override
    public void printMenu() {
        System.out.println("Insert a digit to select menu option:");
        System.out.println("Option 1: Add new task");
        System.out.println("Option 2: Edit task list");
        System.out.println("Option 3: Delete task list");
        System.out.println("Option 4: Mark as done");
        System.out.println("Option 5: Back to Main menu");
    }
}

