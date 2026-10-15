package com.filipeleal.springlearning;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskRepositoryTest {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskRepositoryTest(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Test
    void shouldGenerateIdWhenSavingTask() {
        Task task = new Task("Persist with JPA");
        Task persistentTask = taskRepository.save(task);
        assertTrue(persistentTask.getId() > 0);
    }

    @Test
    void shouldFindSavedTaskById() {
        Task task = new Task("Persist with JPA");
        Task persistentTask = taskRepository.save(task);
        Optional<Task> optionalTask = taskRepository.findById(persistentTask.getId());
        Task assertTask = optionalTask.orElseThrow();
        assertEquals("Persist with JPA", assertTask.getDescription());
    }
}
