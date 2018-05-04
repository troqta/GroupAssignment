package com.calendar;

import com.calendar.Interfaces.Viewable;

public class CalendarObject implements Viewable {
    private String name;
    private String creationDate;
    private String date;

    public CalendarObject(String name, String creationDate, String date) {
        this.name = name;
        this.creationDate = creationDate;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public void view() {
        System.out.println(name);
        System.out.println(date);
    }
}
