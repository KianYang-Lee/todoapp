package com.example.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springproject.entities.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
