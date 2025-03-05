package com.softserve.itacademy.model;

public class Task {
    private int id;
    private String title;
    private String description; // Add description field
    private Priority priority;
    private boolean done;


    private static int counter = 1;

    public Task() {
        id = counter++;
    }

    public Task(String title, String description, Priority priority) { // Update constructor
        this.title = title;
        this.description = description;
        this.priority = priority;
        id = counter++;
    }

    public Task(String title, Priority priority) {
        this.title = title;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() { // Add getter
        return description;
    }

    public void setDescription(String description) { // Add setter
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +  // Include in toString()
                ", priority=" + priority +
                '}';
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

}