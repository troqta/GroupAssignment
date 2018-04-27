package com.calendar;

import com.calendar.Menus.LogInMenu;
import com.calendar.Menus.MainMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public void logIn(){
        System.out.println("Enter username: ");
        String username = in.nextLine();
        System.out.println("Enter password: ");
        String password = in.nextLine();
        boolean correctUsername = false;

        for (User user:users) {
            if(user.getUserName().equals(username)) {
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
        if(currentUser == null && !correctUsername){
            System.out.println("No such user");
            logIn();
        }else if(currentUser == null){
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
        if(isAvailable){
            users.add(new User(username,password,fullName));
            System.out.println("Signup successful. Login to continue.");
            logIn();

        }else{
            singUp();
        }
    }

    public void logOut(){
        System.out.println("LogOut successful.");
        currentUser = null;
        new LogInMenu(this).selectOptions();
    }
}
