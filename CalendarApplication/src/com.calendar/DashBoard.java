package com.calendar;

import com.calendar.Event.Appointment;
import com.calendar.Event.Meeting;
import com.calendar.Menus.*;
import com.calendar.ToDo.ShoppingItem;
import com.calendar.ToDo.ShoppingList;
import com.calendar.ToDo.Task;
import com.calendar.ToDo.TaskList;

import java.util.*;

public class DashBoard {
    private Scanner in = new Scanner(System.in);
    private String name;
    private User currentUser;
    private String selectedDate;
    private List<User> users;

    public DashBoard(String name) {
        this.name = name;
        this.currentUser = null;
        this.users = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void logIn() {
        System.out.println("Enter username: ");
        String username = in.nextLine();
        System.out.println("Enter password: ");
        String password = in.nextLine();
        boolean correctUsername = false;

        for (User user : users) {
            if (user.getUserName().equals(username)) {
                correctUsername = true;
                if (user.getPassword().equals(password)) {
                    currentUser = user;
                    System.out.println("Login successful.");
                    new MainMenu(this).selectOptions();
                    break;
                } else {
                    System.out.println("Wrong password.");
                    break;
                }
            }
        }
        if (currentUser == null && !correctUsername) {
            System.out.println("No such user");
            logIn();
        } else if (currentUser == null) {
            logIn();
        }
    }

    public void singUp() {
        System.out.println("Enter username: ");
        String username = in.nextLine();
        System.out.println("Enter password: ");
        String password = in.nextLine();
        System.out.println("Enter full name: ");
        String fullName = in.nextLine();

        boolean isAvailable = true;
        for (User user : users) {
            if (user.getUserName().equals(username)) {
                System.out.println("This username is already taken.");
                isAvailable = false;
            }
        }
        if (isAvailable) {
            users.add(new User(username, password, fullName));
            System.out.println("Signup successful. Login to continue.");
            logIn();

        } else {
            singUp();
        }
    }

    public void logOut() {
        System.out.println("LogOut successful.");
        currentUser = null;
        new LogInMenu(this).selectOptions();
    }

    public void listByDate() {
        System.out.println("Please enter a date: ");
        String date = in.nextLine();
        for (CalendarObject obj : currentUser.getSchedule()) {
            if (obj.getDate().equals(date)) {
                obj.view();
            }
        }
    }

    public void showCalendar() {
        HashSet<String> days = new HashSet<>();
        int objectCounter = 0;
        for (CalendarObject obj : currentUser.getSchedule()) {
            days.add(obj.getDate());
        }
        TreeSet<String> sortedDays = new TreeSet<>(days);
        for (String date : sortedDays) {
            for (CalendarObject obj : currentUser.getSchedule()) {
                if (obj.getDate().equals(date)) {
                    objectCounter++;
                }

            }
            System.out.println(date + " has " + objectCounter + " objects");
            System.out.println();
            objectCounter = 0;
        }
    }

    public void viewCalendarObject(String objectName) {
        for (CalendarObject obj : currentUser.getSchedule()) {
            if (obj.getName().equals(objectName)) {
                CalendarObject object = obj;
                obj.view();
                if (obj instanceof Meeting) {
                    new ViewMeetingMenu(this, (Meeting) obj).selectOptions();
                }
                if (obj instanceof ShoppingList) {

                }
                if (obj instanceof TaskList) {
                    new ViewTaskListMenu(this, (TaskList) obj).selectOptions();
                }
                if (obj instanceof Appointment) {
                    new ViewAppointmentMenu(this, (Appointment) obj).selectOptions();
                }
                break;
            }
        }
    }

    public void editName(CalendarObject object) {
        String name = in.nextLine();
        System.out.print("Insert new name: ");
        object.setName(name);
    }

    public void changeDate(CalendarObject object) {
        String date = in.nextLine();
        System.out.print("Insert new date: ");
        object.setDate(date);
    }
    public void addTask (TaskList taskList){
        System.out.print("Insert task name: ");
        String name = in.nextLine();
        System.out.print("Insert description: ");
        String description = in.nextLine();
        System.out.print("Insert task deadline: ");
        String deadline = in.nextLine();

        taskList.getTasks().add(new Task(name, description, deadline));
    }
    public void addShoppingItem (ShoppingList shoppingList) {
        System.out.print("Insert shopping item name: ");
        String name = in.nextLine();
        System.out.print("Insert shopping item quantity: ");
        int quantity = in.nextInt();
        System.out.print("Insert shopping item price: ");
        double price = in.nextDouble();

        shoppingList.getItems().add(new ShoppingItem(name, quantity, price));
    }
}
