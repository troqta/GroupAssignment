package com.calendar;

import com.calendar.Event.Appointment;
import com.calendar.Event.AppointmentTypes;
import com.calendar.Event.Meeting;
import com.calendar.Event.MeetingTypes;
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
                    System.out.println();
                    new MainMenu(this).selectOptions();
                    break;
                } else {
                    System.out.println("Wrong password.");
                    System.out.println();
                    break;
                }
            }
        }
        if (currentUser == null && !correctUsername) {
            System.out.println("No such user");
            System.out.println();
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
                System.out.println();
                isAvailable = false;
            }
        }
        if (isAvailable) {
            users.add(new User(username, password, fullName));
            System.out.println("Signup successful. Login to continue.");
            System.out.println();
            logIn();

        } else {
            singUp();
        }
    }

    public void logOut() {
        System.out.println("LogOut successful.");
        System.out.println();
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

    public void viewCalendarObject() {
        System.out.println("Enter name of object that you want to view:");
        String objectName = in.nextLine();
        for (CalendarObject obj : currentUser.getSchedule()) {
            if (obj.getName().equals(objectName)) {
                obj.view();
                if (obj instanceof Meeting) {
                    new ViewMeetingMenu(this, (Meeting) obj).selectOptions();
                    System.out.println();
                }
                if (obj instanceof ShoppingList) {
                    new ViewShoppingListMenu(this, (ShoppingList) obj).selectOptions();
                    System.out.println();

                }
                if (obj instanceof TaskList) {
                    new ViewTaskListMenu(this, (TaskList) obj).selectOptions();
                    System.out.println();
                }
                if (obj instanceof Appointment) {
                    new ViewAppointmentMenu(this, (Appointment) obj).selectOptions();
                    System.out.println();
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
    private User getUserByName(String name){
        for (User user: users) {
            if(user.getFullName().toLowerCase().equals(name.toLowerCase())){
                return user;
            }
        }
        return null;
    }
    public void createMeeting(){
        System.out.println("Insert meeting name:");
        String name = in.nextLine();
        System.out.println("Insert date:");
        String date = in.nextLine();
        System.out.println("Insert meeting topic:");
        String topic = in.nextLine();
        System.out.println("Insert meeting location:");
        String location = in.nextLine();
        System.out.println("Insert meeting duration:");
        String duration = in.nextLine();
        System.out.println("Insert link to meeting platform:");
        String linkToMeetingPlatform = in.nextLine();
        System.out.println("Insert meeting type(Business, Teambuilding):");
        String stringType = in.nextLine();
        MeetingTypes type= null;
        for(MeetingTypes meetingType : MeetingTypes.values()){
            if(stringType.toLowerCase().equals(meetingType.toString().toLowerCase())){
                type = meetingType;
                break;
            }
        }
        System.out.println("Insert meeting attachment filepath. Leave empty if it will be uploaded later:");
        String filePath = in.nextLine();

        currentUser.getSchedule().add(new Meeting(name, new Date().toString(), date, topic, location, duration, linkToMeetingPlatform, type, filePath));
    }
    public void createAppointment(){
        System.out.println("Insert appointment name:");
        String name = in.nextLine();
        System.out.println("Insert date:");
        String date = in.nextLine();
        System.out.println("Insert appointment topic:");
        String topic = in.nextLine();
        System.out.println("Insert appointment location:");
        String location = in.nextLine();
        System.out.println("Insert appointment duration:");
        String duration = in.nextLine();
        System.out.println("Insert appointment type(Chatting, Drinking, Date):");
        String stringType = in.nextLine();
        AppointmentTypes type= null;
        for(AppointmentTypes appointmentType : AppointmentTypes.values()){
            if(stringType.toLowerCase().equals(appointmentType.toString().toLowerCase())){
                type = appointmentType;
                break;
            }
        }
        System.out.println("Insert friend name:");
        String friendString = in.nextLine();
        User friend = getUserByName(friendString);

        currentUser.getSchedule().add(new Appointment(name, new Date().toString(), date, topic, location, duration, type, friend));
    }
    public void createShoppingList(){
        System.out.println("Insert shopping list name");
        String name = in.nextLine();
        System.out.println("Insert date");
        String date = in.nextLine();
        System.out.println("Insert shopping list deadline");
        String deadline = in.nextLine();

        currentUser.getSchedule().add(new ShoppingList(name, new Date().toString(), date, deadline));

    }
    public void createTaskList(){
        System.out.println("Insert task list name");
        String name = in.nextLine();
        System.out.println("Insert date");
        String date = in.nextLine();
        System.out.println("Insert task list deadline");
        String deadline = in.nextLine();

        currentUser.getSchedule().add(new TaskList(name, new Date().toString(), date, deadline));

    }
}
