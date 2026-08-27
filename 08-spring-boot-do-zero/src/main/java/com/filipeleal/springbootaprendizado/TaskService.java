package com.filipeleal.springbootaprendizado;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(String description) {
        Task task = new Task(description);
        return taskRepository.save(task);
    }

    public List<Task> listTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task completeTask(long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        Task task = optionalTask.orElse(null);

        if (task != null) {
            task.setDone();
            taskRepository.save(task);
        }

        return task;
    }

    public boolean deleteTask(long id) {
        boolean task = taskRepository.existsById(id);

        if (task) {
            taskRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
