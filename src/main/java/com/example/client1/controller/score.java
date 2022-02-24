package com.example.client1.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class score {
    @PostMapping("/quizList")
    public String score() {
        return "success";
    }


}
