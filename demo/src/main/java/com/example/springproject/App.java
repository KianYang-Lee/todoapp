package com.example.springproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.example.springproject" })
@EntityScan(basePackages = { "com.example.springproject.entities" })
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}