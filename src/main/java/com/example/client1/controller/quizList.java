package com.example.client1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class quizList {

        @RequestMapping("/quizList")
        public ModelAndView quizList(){
            ModelAndView iMav = new ModelAndView();
            //set the model and view to AddPractitioner Template
            iMav.setViewName("quizList");
            return iMav;
        }

}
