package com.example.client1.controller;

import com.example.client1.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexPageController {

    private QuoteRepository quoteRepository;

    @Autowired
    public IndexPageController(QuoteRepository qR) {
        quoteRepository = qR;
    }

    // Routes index page.

    @RequestMapping("/index")
    public String index() {
        return "index";
      }

     // Using RequestMapping to display all quotes from quotes table in charity database using GET request.

    @RequestMapping(path = "index", method = RequestMethod.GET)
    public ModelAndView displayAllQuotes() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("quotes", quoteRepository.displayAllQuotes());
        mav.setViewName("index");
        return mav;

    }
}
