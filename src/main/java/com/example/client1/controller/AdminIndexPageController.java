package com.example.client1.controller;

import com.example.client1.DTO.QuotesDTO;
import com.example.client1.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminIndexPageController {

    private QuoteRepository quoteRepository;


    @Autowired
    public AdminIndexPageController(QuoteRepository qR) {
        quoteRepository = qR;
    }

    // Routes adminIndexPage.

    @RequestMapping ("adminIndex")
    public String adminIndex() {
        return "adminIndex";
    }

    // Using RequestMapping to display all quotes using GET request.

    @RequestMapping(path = "adminIndex", method = RequestMethod.GET)
    public ModelAndView displayAllQuotes() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("quotes", quoteRepository.displayAllQuotes());
        mav.setViewName("adminIndex");
        return mav;
    }

    // Using RequestMapping to add a quote using POST request.

//    @RequestMapping(path="adminIndex", method = RequestMethod.POST)
//    public ModelAndView addQuote(QuotesDTO quotesDTO) {
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("adminIndex");
//        if (quoteRepository.addQuote(quotesDTO)) {
//            mav.addObject("quotes", quoteRepository.addQuote(quotesDTO));
//            mav.setViewName("index");
//        }
//        return mav;
//    }

    // Using RequestMapping to delete a quote using POST request.

    @RequestMapping(path="adminIndex", method = RequestMethod.POST)
    public ModelAndView deleteQuote(QuotesDTO quotesDTO) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("adminIndex");
        if(quoteRepository.deleteQuote(quotesDTO)){
            mav.addObject("quotes", quoteRepository.deleteQuote(quotesDTO));
            mav.setViewName("adminIndex");
        }
        return mav;
    }
}
