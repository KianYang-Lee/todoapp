package com.example.todoapp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {
  private final static Logger logger = LoggerFactory.getLogger(ViewController.class);
  @Value("${server.port}")
  private String port;

  @Value("${my.name}")
  private String myName;

  @GetMapping("/")
  ModelAndView showHomePage(Model model) {
    logger.info("Fetching home page...");
    String url = "http://localhost/" + port;
    logger.info("Server hosted at: " + url);
    logger.info("App title will be rendered as " + myName);
    model.addAttribute("myName", myName);
    return new ModelAndView("tasks.html");
  }
}
