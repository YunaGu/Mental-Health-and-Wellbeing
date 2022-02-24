package com.example.client1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class scores {

    @RequestMapping("/score.html")
    public String scores(){
        return "score";
    }

}
