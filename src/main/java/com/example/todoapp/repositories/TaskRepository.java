package com.example.todoapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todoapp.entities.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
