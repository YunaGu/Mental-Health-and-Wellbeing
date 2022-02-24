//package com.example.client1.controller;
//
////import com.example.client1.Contact;
//
//import com.example.client1.DTO.Contact;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.ArrayList;
//
//@Controller
//public class ContactPageController {
//
//    ArrayList<Contact> userDetails = new ArrayList<>();
//
//    @RequestMapping(path="/processFormPostHTMLReturn", method = RequestMethod.POST)
//    public ModelAndView postFormProcessor(Contact contact) {
//        userDetails.add(contact);
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("data", contact);
//        mav.addObject("data", contact);
//        mav.addObject("data", contact);
//        mav.addObject("data", contact);
//        mav.setViewName("contact");
//        return mav;
//    }
//
//
//}

package com.example.client1.controller;

import com.example.client1.DTO.Contact;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactPageController {
    JdbcTemplate jdbcTemplate;

    public ContactPageController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping(path="/postContactFormHTMLReturn")
    public String AddContact(Contact contact) {
        try{
            jdbcTemplate.update("insert into userquery (firstName, lastName, email, message) VALUES (?,?,?,?)",
            contact.getFirstName(), contact.getLastName(), contact.getEmail(), contact.getMessage());
            System.out.println("User query successfully added to database!");
        } catch (DataAccessException e) {
            e.printStackTrace();
            System.out.println("Error adding user query to database!");
        }
        return "contact";
    }
}