package com.filipeleal.springbootaprendizado;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class TaskServiceTest {
    private final TaskService taskService;
    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceTest(TaskRepository taskRepository) {
        this.taskService = new TaskService(taskRepository);
        this.taskRepository = taskRepository;
    }

    @BeforeEach
    void clearData() {
        taskRepository.deleteAll();
    }

    @Test
    void shouldCreateTask() {
        Task task = taskService.createTask("JUnit Test");
        assertTrue(task.getId() > 0);
        assertEquals("JUnit Test", task.getDescription());
        assertFalse(task.getDone());
    }

    @Test
    void shouldAssignDifferentIds() {
        Task task1 = taskService.createTask("Task 1");
        Task task2 = taskService.createTask("Task 2");
        assertNotEquals(task1.getId(), task2.getId());
    }

    @Test
    void shouldReturnTaskById() {
        Task task = taskService.createTask("Task with ID 1");
        Task taskById = taskService.getTaskById(task.getId());
        assertEquals(task.getId(), taskById.getId());
        assertEquals(task.getDescription(), taskById.getDescription());
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

        boolean task1Created = false;
        boolean task2Created = false;

        for (Task task : tasks) {
            if (task.getId() == task1.getId()) {
                task1Created = true;
            } 
            
            if (task.getId() == task2.getId()) {
                task2Created = true;
            }
        }

        assertTrue(task1Created);
        assertTrue(task2Created);
    }

    @Test
    void shouldCompleteExistingTask() {
        Task task = taskService.createTask("Task to Complete");
        Task taskCompleted = taskService.completeTask(task.getId());
        assertEquals(task.getId(), taskCompleted.getId());
        assertTrue(taskCompleted.getDone());

        Task taskAfterCompletion = taskService.getTaskById(task.getId());
        assertTrue(taskAfterCompletion.getDone());
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
        assertEquals(task2.getId(), remainingTask.getId());
        assertEquals(task2.getDescription(), remainingTask.getDescription());
    }
}
