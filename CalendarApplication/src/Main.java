import com.calendar.DashBoard;
import com.calendar.Event.*;
import com.calendar.Exceptions.NameLengthException;
import com.calendar.Menus.LogInMenu;
import com.calendar.Menus.Menu;
import com.calendar.ToDo.ShoppingItem;
import com.calendar.ToDo.ShoppingList;
import com.calendar.ToDo.Task;
import com.calendar.ToDo.TaskList;
import com.calendar.User;

public class Main {

    public static void main(String[] args) {

//        Task task = new Task ("testTask", "this is a test task", "2018-04-29");
//        Task task2 = new Task ("testTask2", "this is a test task2", "2018-04-30");
//        Task task3 = new Task ("testTask3", "this is a test task3", "2018-04-31");
//
//        TaskList test = new TaskList("testss", "2018-04-26", "2018-04-28", "2018-04-30");
//
//        test.addTask(task);
//        test.addTask(task2);
//        test.addTask(task3);
//
//        test.markCompleted("testTask2");
//
//        test.view();
//
//
//        ShoppingList listOne = new ShoppingList("testList","2018-04-26", "2018-04-28", "2018-04-30");
//        listOne.addItem(new ShoppingItem("Яйца", 5,5.67));
//        listOne.addItem(new ShoppingItem("Ляп", 3,2.40));
//        listOne.markBought("Яйца");
//        listOne.markBought("Ляп");
//
//        listOne.view();
        //
//
//        EventObject testMeeting = new Meeting("testMeeting", "2018-04-27", "2018-04-28", "testTopic",
//                "u nas", "5 min", "www.pornhub.com", MeetingTypes.TEAMBUILDING, null );
//        EventObject testAppointment = new Appointment("testAppointment", "2018-04-27", "2018-04-28", "klecane"
//        ,"u tqh", "kolkot tolkoz", AppointmentTypes.DATE, martinIvanov);
//
//        ((Meeting) testMeeting).download();
//        ((Meeting) testMeeting).upload("NESHTO SI");
//        ((Meeting) testMeeting).download();
//        ((Meeting) testMeeting).addParticipant(martinIvanov);
//        ((Meeting) testMeeting).addParticipant(danailIvanov);
//        ((Meeting) testMeeting).addParticipant(alexanderSimeonov);
//        testMeeting.view();
//
//        testAppointment.view();
//
        try {


            User martinIvanov = new User("Sexi_Pi4_91", "martin1ivanov", "Martin Ivanov");
            User danailIvanov = new User("danail", "1234567", "Danail Ivanov");
            User alexanderSimeonov = new User("lmaooooo", "12345", "Alexander Simeonov");
            DashBoard test = new DashBoard("test dashboarfd");
            test.getUsers().add(martinIvanov);
            test.getUsers().add(danailIvanov);
            test.getUsers().add(alexanderSimeonov);
            Menu menu = new LogInMenu(test);
            menu.selectOptions();
        }
        catch (NameLengthException e) {
            System.out.println(e.getMessage());
        }


    }
}
