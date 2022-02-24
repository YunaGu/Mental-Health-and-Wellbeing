package com.example.client1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExtraMaterialsController {
    @GetMapping("membersArea/extraMaterials")
    public String extraMaterials() {
        return "extraMaterials";
    }

    @GetMapping("membersArea/extraMaterials/meditation")
    public String meditation() {
        return "meditation";
    }

    @GetMapping("membersArea/extraMaterials/motivation")
    public String motivation() {
        return "motivation";
    }

    @GetMapping("membersArea/extraMaterials/wellbeing")
    public String wellbeing() {
        return "wellbeing";
    }

    @GetMapping("membersArea/extraMaterials/massage")
    public String massage() {
        return "massage";
    }
}
