package com.example.client1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class genController {
    //    mapping for registration page - WILL BE MOVED TO A GENERAL CONTROLLER - in temporary controller currently !
    @RequestMapping(path="/Register", method = RequestMethod.GET)
    public ModelAndView addMember(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("RegisterForm");
        return mav;
    }

    @GetMapping("403")
    public String fitness() {
        return "error_403";
    }
}
