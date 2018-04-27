package com.calendar.Event;

public enum AppointmentTypes {
    CHATTING("Chatting"), DRINKING("Drinking"), DATE("Date");
    private final String name;
    AppointmentTypes(String name){
        this.name=name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
