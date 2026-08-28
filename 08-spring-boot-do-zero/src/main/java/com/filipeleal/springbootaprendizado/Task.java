package com.filipeleal.springbootaprendizado;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "task_description", nullable = false, length = 200)
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private boolean done;

    protected Task() {

    }

    public Task(String description) {
        this.description = description;
    }

    public Task(String description, Category category) {
        this.description = description;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public boolean getDone() {
        return done;
    }

    public void setDone() {
        this.done = true;
    }
}
