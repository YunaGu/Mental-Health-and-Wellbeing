package com.example.client1.controller;

import com.example.client1.repository.AdminQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminViewUserQueryController {

    private AdminQueryRepository adminQueryRepository;

    @Autowired
    public AdminViewUserQueryController(AdminQueryRepository aQR) {
       adminQueryRepository = aQR;
    }

    @RequestMapping("adminUserQuery")
    public String adminUserQuery() {
            return "adminUserQuery";
        }

    @RequestMapping(path = "adminUserQuery", method = RequestMethod.GET)
    public ModelAndView displayAllQueries() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("queries", adminQueryRepository.displayAllQueries());
        mav.setViewName("adminUserQuery");
        return mav;
    }
}



