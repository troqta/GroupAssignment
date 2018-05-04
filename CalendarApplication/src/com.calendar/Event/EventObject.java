package com.calendar.Event;

import com.calendar.CalendarObject;
import com.calendar.Interfaces.Attendable;

public abstract class EventObject extends CalendarObject implements Attendable {
    private String topic;
    private String location;
    private String duration;
    private boolean attended;


    public EventObject(String name, String creationDate, String date, String topic,
                       String location, String duration) {
        super(name, creationDate, date);
        this.topic = topic;
        this.location = location;
        this.duration = duration;
        this.attended = false;


    }

    public String getTopic() {
        return topic;
    }


    public String getLocation() {
        return location;
    }
    public String getDuration() {
        return duration;
    }


    public boolean isAttended() {
        return attended;
    }

    public abstract void getReminder();

    @Override
    public void attend() {
        System.out.println("Event has been attended");
        attended = true;
    }
}
