package com.calendar.ToDo;

import com.calendar.CalendarObject;

public abstract class ToDoObject extends CalendarObject {
    private String deadline;
    private boolean isDone;

    ToDoObject(String name, String creationDate, String date, String deadline) {
        super(name, creationDate, date);
        this.deadline = deadline;
        this.isDone = false;
    }
    void setDone(boolean done) {
        isDone = done;
    }

    public abstract void markDone();

}
