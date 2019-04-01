package com.cedrus.practice.todo.Spring_Boot_Todos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String home() { return "Todos API running!"; }
}
