package com.example.todoapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.todoapp.entities.Task;
import com.example.todoapp.repositories.TaskRepository;

@Configuration
class GenerateDatabase {
  private static final Logger logger = LoggerFactory.getLogger(GenerateDatabase.class);

  @Bean
  CommandLineRunner initDatabase(TaskRepository taskRepository) {
    return args -> {
      logger.info("Populating database...");
      Task task1 = new Task("Grocery shopping", 5L);
      Task task2 = new Task("Visit friends", 1L);
      Task task3 = new Task("Cooking dinner", 3L);
      taskRepository.save(task1);
      taskRepository.save(task2);
      taskRepository.save(task3);
      logger.info(String.format("Populated DB with task 1: %s and task 2: %s and task 3: %s", task1.toString(),
          task2.toString(), task3.toString()));
    };
  }
}