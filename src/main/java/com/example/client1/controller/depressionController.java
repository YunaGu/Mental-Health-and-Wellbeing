package com.example.client1.controller;

import com.example.client1.DTO.DepressionDTO;
import com.example.client1.DTO.Quiz;
import com.example.client1.Service.DepressionSevice;
import com.example.client1.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class depressionController {
    @Autowired
    private DepressionSevice depressionService;

    @RequestMapping(value = "/depression", method = RequestMethod.GET)
    public String depression(Model model) {
        List<DepressionDTO> depression = depressionService.getQues();
        model.addAttribute("depression", depression);
        return "depression";

    }
}
