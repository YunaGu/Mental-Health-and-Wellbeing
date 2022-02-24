package com.example.client1.controller;

import com.example.client1.DTO.Recipient;
import com.example.client1.form.RegisterForm;
import com.example.client1.repository.MemberRepository;
import com.example.client1.repository.RecipientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//controller that uses jdbctemplate and a post mapping to add recipients email and name to "recipients table in mysql
@Controller
public class RecipientController {
//    final
//    JdbcTemplate jdbcTemplate;

    private RecipientRepository recipientRepo;


//    public RecipientController(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }

    @Autowired
    public RecipientController(RecipientRepository rRepo) {
        recipientRepo = rRepo;
    }

//    @PostMapping(path = "newspage")
//    public String signupRecipient(Recipient recipient) {
//    try {
//        jdbcTemplate.update("insert into recipients (recipient_email, first_name, last_name) VALUES (?,?,?)",
//                recipient.getRecipient_email(), recipient.getFirst_name(), recipient.getLast_name());
//        System.out.println("Successfully signed-up user to newsletter.");
//    }
//    catch (Exception e)
//    {
//        System.err.println("An error occurred when trying to register a user to the newsletter\n"+ e.getMessage());
//    }
//        return "news";  //todo change this to show a different "success" page where user knows they have submitted OR add some js
//    }
@RequestMapping(path="newspage", method = RequestMethod.POST)
public ModelAndView signupRecipient(Recipient recipient) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("news");
    if (recipientRepo.signupRecipient(recipient)) {
        System.out.println("Successfully registered new member!");
        mav.addObject("recipients",recipientRepo.findAllRecipients());
        mav.setViewName("index");
    }
    return mav;

}

    @RequestMapping(path="viewRecipients",method = RequestMethod.GET)
    public ModelAndView viewRecipients() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("recipients", recipientRepo.findAllRecipients());
        mav.setViewName("viewRecipients");
        return mav;
    }
}