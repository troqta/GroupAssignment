package com.calendar.Event;

import com.calendar.Interfaces.Downloadable;
import com.calendar.Interfaces.Uploadable;
import com.calendar.Interfaces.Viewable;
import com.calendar.User;

import java.util.ArrayList;
import java.util.List;

public class Meeting extends EventObject implements Downloadable, Uploadable, Viewable {

    private List<User> participants;
    private String linkToMeetingPlatform;
    private MeetingTypes type;
    private String filePath;

    public Meeting(String name, String creationDate, String date, String topic,
                       String location, String duration, String linkToMeetingPlatform, MeetingTypes type,
                   String filePath){
        super(name, creationDate, date, topic, location, duration);
        this.participants= new ArrayList<>();
        this.linkToMeetingPlatform = linkToMeetingPlatform;
        this.type=type;
        this.filePath=filePath;

    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }

    public String getLinkToMeetingPlatform() {
        return linkToMeetingPlatform;
    }

    public void setLinkToMeetingPlatform(String linkToMeetingPlatform) {
        this.linkToMeetingPlatform = linkToMeetingPlatform;
    }
    public void addParticipant(User user){
        participants.add(user);
    }

    public MeetingTypes getType() {
        return type;
    }

    public void setType(MeetingTypes type) {
        this.type = type;
    }

    public String getFilePath() {
        return filePath;
    }

    @Override
    public void getReminder() {
        if(type==MeetingTypes.BUSINESS) {
            System.out.println("Dress properly for a business meeting and dont forget your notes");
        }
        if(type==MeetingTypes.TEAMBUILDING) {
            System.out.println("Get ready for fun and bring your laughs");
        }
    }

    @Override
    public void download() {
        if(filePath==null){
            System.out.println("Error 404: File not found!");
        }
        else {
            System.out.println("Meeting file from filepath: " + filePath + " has been downloaded!");
        }
    }

    @Override
    public void upload(String path) {
        this.filePath=path;
    }
    @Override
    public void view(){
        System.out.println("Meeting name: "+getName());
        System.out.println("Meeting topic: "+ getTopic());
        System.out.println("Meeting type: "+type);
        System.out.println("Meeting date: "+getDate());
        System.out.println("Participants");
        listParticipants();
        System.out.println("Meeting duration: "+getDuration());
        System.out.println("Location: "+getLocation());
    }
    public void listParticipants(){
        participants.stream().forEach(x-> System.out.println(" - "+x.getFullName()));
    }
}
