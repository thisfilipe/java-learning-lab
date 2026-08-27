package com.filipeleal.springbootaprendizado;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;
    private boolean done;

    protected Task() {

    }

    public Task(String description) {
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
