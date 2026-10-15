package com.filipeleal.springbootaprendizado;

import jakarta.persistence.EntityManager;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class EntityManagerLifecycleTest {
    private final EntityManager entityManager;

    @Autowired
    public EntityManagerLifecycleTest(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Test
    void shouldObserveTransientEntity() {
        Task task = new Task("Study EntityManager");
        assertFalse(entityManager.contains(task));

        entityManager.persist(task);
        assertTrue(entityManager.contains(task));

        entityManager.flush();
        assertTrue(entityManager.contains(task));

        entityManager.clear();
        assertFalse(entityManager.contains(task));

        Task foundTask = entityManager.find(Task.class, task.getId());
        assertTrue(entityManager.contains(foundTask));
        assertNotSame(task, foundTask);
        assertEquals(task.getId(), foundTask.getId());

        Task foundAgain = entityManager.find(Task.class, foundTask.getId());
        assertSame(foundTask, foundAgain);
    }

    @Test
    void shouldPersistThenFlush() {
        Task task = new Task("Task to Flush");
        entityManager.persist(task);
        entityManager.flush();
        task.setDone();
        entityManager.flush();

        entityManager.clear();

        Task foundTask = entityManager.find(Task.class, task.getId());
        assertTrue(foundTask.getDone());
    }
}
