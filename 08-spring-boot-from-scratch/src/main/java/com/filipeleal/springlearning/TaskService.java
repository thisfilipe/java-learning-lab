package com.filipeleal.springlearning;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final CategoryRepository categoryRepository;

    public TaskService(TaskRepository taskRepository, CategoryRepository categoryRepository) {
        this.taskRepository = taskRepository;
        this.categoryRepository = categoryRepository;
    }

    public Task createTask(String description) {
        Task task = new Task(description);
        return taskRepository.save(task);
    }

    public Task createTask(String description, long categoryId) {
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        Category category = optionalCategory.orElse(null);

        if (category != null) {
            Task task = new Task(description, category);
            return taskRepository.save(task);
        }
        
        return null;
    }

    public List<Task> listTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Transactional
    public Task completeTask(long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        Task task = optionalTask.orElse(null);

        if (task != null) {
            task.setDone();
        }

        return task;
    }

    public List<Task> listCompletedTasks() {
        return taskRepository.findCompletedTasks();
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
