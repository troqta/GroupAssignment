package com.calendar;

import com.calendar.Exceptions.NameLengthException;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userName;
    private String password;
    private String fullName;
    private List<CalendarObject> schedule;
    private List<User> friends;

    public User(String userName, String password, String fullName) {
        try {
            setUserName(userName);
            setPassword(password);
            this.fullName = fullName;
            schedule = new ArrayList<>();
            friends = new ArrayList<>();

        } catch (NameLengthException e) {
            System.out.println(e.getMessage());
        }

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) throws NameLengthException {

        if (userName.length() < 6) {
            throw new NameLengthException("Username must be at least 6 characters long");
        }
        if (userName.length() >= 20) {
            throw new NameLengthException("Username must be no longer thant 20 characters");
        }
        if(userName.contains(" ")){
            throw new NameLengthException("Username must not contain whitespaces");
        }
        this.userName = userName;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws NameLengthException {
        if (!password.matches(".*\\d+.*")) {
            throw new NameLengthException("Password must contain at least one digit");
        }
        if (password.length() < 5) {
            throw new NameLengthException("Password must be at least 5 characters long");
        }
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) throws NameLengthException{
        if (fullName.length() < 6) {
            throw new NameLengthException("Name must be at least 6 characters long");
        }
        if (fullName.length() >= 20) {
            throw new NameLengthException("Name must be no longer thant 20 characters");
        }
        this.fullName = fullName;
    }

    public List<CalendarObject> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<CalendarObject> schedule) {
        this.schedule = schedule;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public void addFriend(User user) {
        friends.add(user);
    }

    public void addCalendarObject(CalendarObject object) {
        schedule.add(object);
    }

    public void listFriends() {
        friends.forEach(System.out::println);
    }

    public void listCalendarObjects() {
        schedule.forEach(System.out::println);
    }
}
