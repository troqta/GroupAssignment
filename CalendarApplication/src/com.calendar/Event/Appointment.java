package com.calendar.Event;

import com.calendar.Interfaces.Viewable;
import com.calendar.User;

public class Appointment extends EventObject implements Viewable {

    private AppointmentTypes type;
    private User friend;

    public Appointment(String name, String creationDate, String date, String topic, String location, String duration,
                       AppointmentTypes type, User friend) {
        super(name, creationDate, date, topic, location, duration);
        this.type=type;
        this.friend=friend;
    }

    @Override
    public void getReminder() {
        if(type==AppointmentTypes.CHATTING){
            System.out.println("Get ready for a chat with " +friend.getFullName());
        }
        else if(type==AppointmentTypes.DRINKING){
            System.out.println("Time to get drunk with "+friend.getFullName()+"! Dont forget to take a cab back home!");
        }
        else if(type==AppointmentTypes.DATE){
            System.out.println("Its time to go pick up "+friend.getFullName()+" and bring them to "+ getLocation());
        }
    }
    @Override
    public void view(){
        System.out.println("Appointment name: "+getName());
        System.out.println("Appointment topic: "+ getTopic());
        System.out.println("Appointment type: "+type);
        System.out.println("Appointment date: "+getDate());
        System.out.println("Appointment buddy: " +friend.getUserName());
        System.out.println("Appointment location: "+getLocation());
        if(isAttended()){
            System.out.println("Appointment has already been attended");
        }
        else System.out.println("Appointment has yet to be attended");
        System.out.println();

    }
}
