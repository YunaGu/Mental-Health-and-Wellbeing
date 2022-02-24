package com.example.client1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class socialMediaController {
        @RequestMapping("/socialMedia")
        public String socialMedia(){
            return "socialMedia";
        }
}
