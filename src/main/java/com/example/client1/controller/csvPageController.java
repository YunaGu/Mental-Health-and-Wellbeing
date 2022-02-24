package com.example.client1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class csvPageController {
    @GetMapping("addCSV")
    public String addCSV() {
        return "addCSV";
    }
}
