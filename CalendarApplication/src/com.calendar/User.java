package com.calendar;

import com.calendar.Exceptions.NameLengthException;
import com.calendar.Interfaces.Deletable;

import java.util.ArrayList;
import java.util.List;

public class User implements Deletable {
    private String userName;
    private String password;
    private String fullName;
    private List<CalendarObject> schedule;
    private List<User> friends;

    public User(String userName, String password, String fullName) throws NameLengthException {

            setUserName(userName);
            setPassword(password);
            setFullName(fullName);
            schedule = new ArrayList<>();
            friends = new ArrayList<>();



    }

    public String getUserName() {
        return userName;
    }

    private void setUserName(String userName) throws NameLengthException {

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

    String getPassword() {
        return password;
    }

    private void setPassword(String password) throws NameLengthException {
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

    private void setFullName(String fullName) throws NameLengthException{
        if (fullName.length() < 6) {
            throw new NameLengthException("Name must be at least 6 characters long");
        }
        if (fullName.length() >= 20) {
            throw new NameLengthException("Name must be no longer thant 20 characters");
        }
        this.fullName = fullName;
    }

    List<CalendarObject> getSchedule() {
        return schedule;
    }

    @Override
    public void delete(CalendarObject name) {
        schedule.remove(name);
    }
}
