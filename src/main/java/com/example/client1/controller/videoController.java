package com.example.client1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class videoController {
    @RequestMapping("/video")
    public String video(){
        return "video";
    }
}
