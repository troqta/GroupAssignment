package com.calendar.ToDo;
import java.util.ArrayList;
import java.util.List;

public class TaskList extends ToDoObject {

    private List<Task> tasks;

    public TaskList(String name, String creationDate, String date, String deadline) {
        super(name, creationDate, date, deadline);
        this.tasks = new ArrayList<>();
    }


    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
        System.out.printf("Task %s has been added to your task list", task.getName());
        System.out.println();
        System.out.println();
    }
    @Override
    public void view () {
        System.out.println("Task list name: "+ getName());
        printItems();
    }

    private void printItems() {
        tasks.stream().forEach(x-> System.out.println(" - "+ x.getName() +": " + isTaskCompleted(x)));
    }

    public String isTaskCompleted(Task task){
        if(task.isDone()){
            return "Completed";
        }
        else{
            return "Ignored";
        }

    }

    @Override
    public void markDone() {
        this.setDone(true);

        System.out.println("Completed tasks: ");
        tasks.stream()
                .filter(x -> x.isDone())
                .forEach(System.out::println);

        System.out.println("Uncompleted tasks: ");
        tasks.stream()
                .filter(x -> !x.isDone())
                .forEach(System.out::println);

    }

    public void markCompleted(String name) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getName().equals(name)) {
                tasks.get(i).setDone(true);
                break;
            }

        }
    }
}
