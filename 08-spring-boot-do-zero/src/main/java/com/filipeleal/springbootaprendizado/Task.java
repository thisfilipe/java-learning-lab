package com.filipeleal.springbootaprendizado;

public class Task {
    private long id;
    private String description;
    private boolean done;

    public Task(long id, String description) {
        this.id = id;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean getDone() {
        return done;
    }

    public void setDone() {
        this.done = true;
    }
}
