package com.calendar.Menus;

import com.calendar.DashBoard;
import com.calendar.Event.Appointment;
import com.calendar.Event.Meeting;
import com.sun.tools.javac.Main;

import java.util.Scanner;

public class ViewMeetingMenu extends Menu{
    private Meeting meeting;

    private Scanner in = new Scanner(System.in);

    public ViewMeetingMenu(DashBoard dashBoard, Meeting meeting) {
        super(dashBoard);
        this.meeting = meeting;
    }

    @Override
    public void selectOptions() {
        int option = 0;
        while (option <= 0 || option > 8) {
            printMenu();
            option = in.nextInt();
        }
        switch (option) {
            case 1:
                meeting.attend();
                new ViewMeetingMenu(getDashBoard(),meeting).selectOptions();
                break;
            case 2:
                new EditMenu(getDashBoard(), meeting).selectOptions();
                break;
            case 3:
                getDashBoard().getCurrentUser().delete(meeting);
                System.out.println(meeting.getName() + " deleted successfully");
                new MainMenu(getDashBoard()).selectOptions();
                break;
            case 4:
                meeting.upload(in.nextLine());
                new ViewMeetingMenu(getDashBoard(),meeting).selectOptions();
                break;

            case 5:
                meeting.download();
                new ViewMeetingMenu(getDashBoard(),meeting).selectOptions();
                break;
            case 6:
                meeting.getReminder();
                break;
            case 7:
                getDashBoard().addParticipantToMeeting(meeting);
                new ViewMeetingMenu(getDashBoard(),meeting).selectOptions();
                break;
            case 8:
                new MainMenu(getDashBoard()).selectOptions();
                break;
    }
    }

    @Override
    public void printMenu() {
        System.out.println("Insert a digit to select menu option:");
        System.out.println("Option 1: Attend meeting");
        System.out.println("Option 2: Edit meeting");
        System.out.println("Option 3: Delete meeting");
        System.out.println("Option 4: Upload attachment");
        System.out.println("Option 5: Download attachment");
        System.out.println("Option 6: Get reminder");
        System.out.println("Option 7: Add a participant to meeting");
        System.out.println("Option 8: Back to Main menu");
    }
}
