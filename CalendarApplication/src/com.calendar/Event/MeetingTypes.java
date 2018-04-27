package com.calendar.Event;

public enum MeetingTypes {
    BUSINESS("Business"), TEAMBUILDING("Teambuilding");
    private final String name;
     MeetingTypes(String name){
        this.name=name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
