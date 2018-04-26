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

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
