package com.example.todoapp.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.todoapp.entities.Task;
import com.example.todoapp.repositories.TaskRepository;
import com.example.todoapp.TaskNotFoundException;

import java.util.List;

@RestController
public class TaskController {
  private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

  private final TaskRepository taskRepository;

  TaskController(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  @GetMapping("/tasks")
  List<Task> getTasks() {
    logger.info("GET Request to /tasks endpoint");
    return taskRepository.findAll();
  }

  @PostMapping("/tasks")
  Task createNewTask(@RequestBody Task newTask) {
    logger.info("POST request to /tasks endpoint");
    return taskRepository.save(newTask);
  }

  @GetMapping("/tasks/{id}")
  Task getTask(@PathVariable Long id) {
    logger.info(String.format("GET Request to /tasks/%d endpoint", id));
    return taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
  }

  @PutMapping("/tasks/{id}")
  Task updateTask(@RequestBody Task newTask, @PathVariable Long id) {
    logger.info(String.format("PUT request to /tasks/%d endpoint", id));
    Task savedTask = taskRepository.findById(id).map(task -> {
      task.setDescription(newTask.getDescription());
      task.setPriority(newTask.getPriority());
      return taskRepository.save(task);
    }).orElseGet(() -> {
      newTask.setId(id);
      return taskRepository.save(newTask);
    });
    return savedTask;
  }

  @DeleteMapping("/tasks/{id}")
  void deleteTask(@PathVariable Long id) {
    logger.info(String.format("DELETE request to /tasks/%d endpoint", id));
    taskRepository.deleteById(id);
  }
}
