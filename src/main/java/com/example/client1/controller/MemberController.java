package com.example.client1.controller;

import com.example.client1.DTO.MemberDTO;
import com.example.client1.form.RegisterForm;
import com.example.client1.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {

    private MemberRepository memberRepo;

    @Autowired
    public MemberController(MemberRepository pRepo) {
        memberRepo = pRepo;
    }

// mapping for adding member using if statement and post method
    @RequestMapping(path="/Member", method = RequestMethod.POST)
    public ModelAndView addMember(RegisterForm registerForm) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("RegisterForm");
        if (memberRepo.addMember(registerForm)) {
            System.out.println("Successfully registered new member!");
            mav.addObject("members",memberRepo.findAllMembers());
            mav.setViewName("index");
        }
        return mav;

    }
//    mapping that uses a get request to display view members page where all records of members are shown from mysql table
    @RequestMapping(path="/viewMembers",method = RequestMethod.GET)
    public ModelAndView delete() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("members", memberRepo.findAllMembers());
        mav.setViewName("viewMembers");
        return mav;
    }
//mapping that uses a post request to query mysql table and delete a member by entering their user_ID
    @RequestMapping(path="/viewMembers", method = RequestMethod.POST)
    public ModelAndView deleteMember(MemberDTO memberDTO) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("viewMembers");
        if(memberRepo.deleteMember(memberDTO)){
            mav.addObject("members", memberRepo.findAllMembers());
            mav.setViewName("viewMembers");
        }
    return mav;
    }
}

