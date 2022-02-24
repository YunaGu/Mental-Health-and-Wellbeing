package com.example.client1.controller;

import com.example.client1.DTO.Quiz;
import com.example.client1.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@Controller
public class AnxietyController {

    @Autowired
    private QuizService quizService;

//    @RequestMapping(value = "/quiz", method = RequestMethod.GET)
//    public ModelAndView getQuiz() {
//        ModelAndView modelAndView = new ModelAndView();
//        List<Quiz> quizList = quizService.getQuiz();
//        modelAndView.setViewName("quizDetails");
//        modelAndView.addObject("quizlist",quizList);
//        return modelAndView;
//    }

    @RequestMapping(value = "/anxiety", method = RequestMethod.GET)
    public String quiz(Model model){
        List<Quiz> anxiety = quizService.getQuiz();
        model.addAttribute("anxiety",anxiety);
        return "anxiety";
    }


}

