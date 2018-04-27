package com.calendar.Event;

import com.calendar.CalendarObject;

public abstract class EventObject extends CalendarObject {
    private String topic;
    private String location;
    private String duration;


    public EventObject(String name, String creationDate, String date, String topic,
                       String location, String duration ){
        super(name, creationDate, date);
        this.topic=topic;
        this.location=location;
        this.duration=duration;


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

}
