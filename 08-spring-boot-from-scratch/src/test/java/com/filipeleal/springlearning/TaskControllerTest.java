package com.filipeleal.springlearning;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class TaskControllerTest {
    private final MockMvc mockMvc;
    private final TaskService taskService;

    @Autowired
    TaskControllerTest(MockMvc mockMvc, TaskService taskService) {
        this.mockMvc = mockMvc;
        this.taskService = taskService;
    }

    @Test
    void shouldCreateTask() throws Exception {
        mockMvc.perform(
            post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {"description": "Study tests"}
                        """)
        )
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.description").value("Study tests"))
        .andExpect(jsonPath("$.done").value(false));
    }

    @Test
    void shouldReturnNotFoundForMissingTask() throws Exception {
        mockMvc.perform(
            get("/tasks/999")
        )
        .andExpect(status().isNotFound());
    }

    @Test
    void shouldDeleteExistingTask() throws Exception {
        Task task = taskService.createTask("Task to delete");
        
        mockMvc.perform(
            delete("/tasks/{id}", task.getId())
        )
        .andExpect(status().isNoContent());
        
        mockMvc.perform(
            get("/tasks/{id}", task.getId())
        )
        .andExpect(status().isNotFound());
    }

    @Test
    void shouldCompleteExistingTask() throws Exception {
        Task task = taskService.createTask("Task to complete");
        
        mockMvc.perform(
            patch("/tasks/{id}", task.getId())
        )
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.description").value("Task to complete"))
        .andExpect(jsonPath("$.done").value(true));
    }
}
