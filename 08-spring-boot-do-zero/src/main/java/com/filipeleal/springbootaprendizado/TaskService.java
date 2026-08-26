package com.filipeleal.springbootaprendizado;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final Map<Long, Task> tasks = new HashMap<>();
    private long nextId = 1;

    public Task createTask(String description) {
        Task task = new Task(nextId, description);
        tasks.put(task.getId(), task);
        nextId++;
        return task;
    }

    public List<Task> listTasks() {
        return List.copyOf(tasks.values());
    }

    public Task getTaskById(long id) {
        return tasks.get(id);
    }

    public Task completeTask(long id) {
        Task task = tasks.get(id);

        if (task != null) {
            task.setDone();
        }

        return task;
    }

    public boolean deleteTask(long id) {
        Task task = tasks.remove(id);
        return task != null;
    }
}
