package com.example.todoapp;

public class TaskNotFoundException extends RuntimeException {
  public TaskNotFoundException(Long id) {
    super(String.format("Could not find id: %d", id));
  }
}