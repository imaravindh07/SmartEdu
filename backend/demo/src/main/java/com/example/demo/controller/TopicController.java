package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class TopicController {
    @GetMapping("/test")
    public String testAPI()
    {
        return "SmartEdu backend is running..";
    }

}