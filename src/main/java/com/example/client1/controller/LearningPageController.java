package com.example.client1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LearningPageController {

    @GetMapping("learning")
    public String learning() {
        return "learning";
    }
}
