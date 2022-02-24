package com.example.client1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class downloadPageController {
    @RequestMapping("download.html")
    public String download() {
        return "download";
    }
}
