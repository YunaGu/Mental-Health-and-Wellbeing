package com.example.client1.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.print.attribute.standard.PresentationDirection;

/*
 Controller classes perform the users requested actions. These classes work with model classes and
 select the appropriate view that should be displayed to the user according to user requests.
*/
@Controller
//generalController java class for mapping web requests onto methods.
public class GeneralController {
    //@RequestMapping Annotation for mapping web requests(e.g. /AddPractitioner) onto methods(e.g. addPractitioner()).
    @RequestMapping(path="/AddPractitioner")
    public ModelAndView addPractitioner(){
        ModelAndView iMav = new ModelAndView();
        //set the model and view to AddPractitioner Template
        iMav.setViewName("AddPractitioner");
        return iMav;
    }
    @RequestMapping(path="/DeletePractitioner")
    public ModelAndView deletePractitioner(){
        ModelAndView iMav = new ModelAndView();
        iMav.setViewName("DeletePractitioner");
        return iMav;
    }
    @RequestMapping(path="/SendStory")
    public ModelAndView sendStory(){
        ModelAndView iMav = new ModelAndView();
        iMav.setViewName("SendStory");
        return iMav;
    }
    @RequestMapping(path="/SupportAdmin")
    public ModelAndView supportAdmin(){
        ModelAndView iMav = new ModelAndView();
        iMav.setViewName("SupportAdmin");
        return iMav;
    }

}
