package com.filipeleal.springbootaprendizado;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TaskServiceTest {
    TaskService taskService = new TaskService();

    @Test
    void shouldCreateTask() {
        Task task = taskService.createTask("JUnit Test");
        assertEquals(1, task.getId());
        assertEquals("JUnit Test", task.getDescription());
        assertFalse(task.getDone());
    }

    @Test
    void shouldAssignSequentialIds() {
        Task task1 = taskService.createTask("Task 1");
        Task task2 = taskService.createTask("Task 2");
        assertEquals(1, task1.getId());
        assertEquals(2, task2.getId());
    }

    @Test
    void shouldReturnTaskById() {
        Task task = taskService.createTask("Task with ID 1");
        Task taskById = taskService.getTaskById(task.getId());
        assertSame(task, taskById);
    }

    @Test
    void shouldReturnNullWhenTaskDoesNotExist() {
        Task task = taskService.getTaskById(999);
        assertNull(task);
    }

    @Test
    void shouldListCreatedTasks() {
        Task task1 = taskService.createTask("Task 1");
        Task task2 = taskService.createTask("Task 2");
        List<Task> tasks = taskService.listTasks();
        assertEquals(2, tasks.size());
        assertTrue(tasks.contains(task1));
        assertTrue(tasks.contains(task2));
    }

    @Test
    void shouldCompleteExistingTask() {
        // Arrange
        Task task = taskService.createTask("Task to Complete");

        // Act
        Task taskCompleted = taskService.completeTask(task.getId());

        //Assert
        assertSame(task, taskCompleted);
        assertTrue(taskCompleted.getDone());
    }

    @Test
    void shouldReturnNullWhenCompletingMissingTask() {
        Task task = taskService.completeTask(999);
        assertNull(task);
    }

    @Test
    void shouldDeleteExistingTask() {
        Task task = taskService.createTask("Task to Delete");
        boolean deleted = taskService.deleteTask(task.getId());
        Task taskAfterDeletion = taskService.getTaskById(task.getId());
        assertTrue(deleted);
        assertNull(taskAfterDeletion);
    }

    @Test
    void shouldReturnFalseWhenDeletingMissingTask() {
        boolean deleted = taskService.deleteTask(999);
        assertFalse(deleted);
    }

    @Test
    void shouldStartWithEmptyTaskList() {
        List<Task> tasks = taskService.listTasks();
        assertTrue(tasks.isEmpty());
    }

    @Test
    void shouldNotDeleteOtherTasks() {
        Task task1 = taskService.createTask("Task 1");
        Task task2 = taskService.createTask("Task 2");
        taskService.deleteTask(task1.getId());
        Task remainingTask = taskService.getTaskById(task2.getId());
        assertNull(taskService.getTaskById(task1.getId()));
        assertSame(task2, remainingTask);
    }
}
