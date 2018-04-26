package com.calendar.ToDo;

import com.calendar.CalendarObject;

public abstract class ToDoObject extends CalendarObject {
    private String deadline;
    private boolean isDone;

    public ToDoObject(String name, String creationDate, String date, String deadline) {
        super(name, creationDate, date);
        this.deadline = deadline;
        this.isDone = false;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public abstract void markDone();

}
