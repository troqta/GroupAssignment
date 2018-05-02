package com.calendar.Event;

import com.calendar.CalendarObject;
import com.calendar.Interfaces.Attendable;

import java.sql.SQLOutput;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class EventObject extends CalendarObject implements Attendable {
    private String topic;
    private String location;
    private String duration;
    private boolean hasBeenAttended;


    public EventObject(String name, String creationDate, String date, String topic,
                       String location, String duration) {
        super(name, creationDate, date);
        this.topic = topic;
        this.location = location;
        this.duration = duration;
        this.hasBeenAttended = false;


    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public abstract void getReminder();

    @Override
    public void attend() {
        System.out.println("Event has been attended");
        hasBeenAttended = true;
    }
}
