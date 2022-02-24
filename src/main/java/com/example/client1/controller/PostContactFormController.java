package com.example.client1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostContactFormController {
        @GetMapping("/postContactFormHTMLReturn")
        public String postContactFormHTMLReturn() {
            return "postContactFormHTMLReturn";
        }
    }


