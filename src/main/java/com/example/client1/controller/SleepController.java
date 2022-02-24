package com.example.client1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Because the front and back end code are not separated
 * Back end mapping front end page(sleep)
 */
@Controller
public class SleepController {
    @RequestMapping("/sleep")
    public String sleep(){
        return "sleep";
    }

 }



