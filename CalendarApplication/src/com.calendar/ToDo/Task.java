package com.calendar.ToDo;

public class Task {
    private String name;
    private String description;
    private String deadline;
    private boolean isDone;

    public Task(String name, String description, String deadline) {
        this.name = name;
        this.description = description;
        this.deadline = deadline;
        this.isDone = false;
    }

    public String getName() {
        return name;
    }

    boolean isDone() {
        return isDone;
    }

    void setDone(boolean done) {
        isDone = done;
    }
}
