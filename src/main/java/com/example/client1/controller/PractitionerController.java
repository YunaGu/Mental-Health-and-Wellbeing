package com.example.client1.controller;

import com.example.client1.form.AddPractitionerForm;
import com.example.client1.repository.PractitionerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
/*
In MVC the access to the database returns some data from storage in
the form of a ResultSet, The controller needs to pass a data object
and a template to the view layer (Thymeleaf).
PractitionerController process requests and organise data collection.
*/
public class PractitionerController {

    private PractitionerRepository practitionerRepository;
    /*
        Autowired means that when framework compiles the server code, it registers this instance of the PractitionerRepository created
        by the framework and will use it when needed .
    */
    @Autowired
    public PractitionerController(PractitionerRepository iRepo) {
        practitionerRepository = iRepo;
    }
    /*
    @RequestMapping Annotation for mapping web requests(/bookSession) onto methods (showAll).
    This method finds all practitioners from database and sends them to bookSession.html(view layer)
    with iMav(Model and view object)
    */
    @RequestMapping(path="/bookSession")
    public ModelAndView showAll() {
        ModelAndView iMav = new ModelAndView();
        iMav.addObject("practitioners",practitionerRepository.findAllPractitioners());
        iMav.setViewName("bookSession");
        return iMav;
    }
    //this method adds a practitioner to database. The data located in addPractitionerForm object.
    @RequestMapping(path="/AddPractitioner/" , method = RequestMethod.GET)
    public ModelAndView addPractitioner(AddPractitionerForm addPractitionerForm) {
        ModelAndView iMav = new ModelAndView();

        iMav.setViewName("AddPractitioner");
        //if data successfully written in the database stay in bookSession.htm page and show all results.
        if (practitionerRepository.addPractitioner(addPractitionerForm)) {
            System.out.println("practitioner added");
            iMav.clear();
            iMav.addObject("practitioners", practitionerRepository.findAllPractitioners());
            iMav.setViewName("bookSessionAdmin");
        }
        return iMav;
    }
    //This method removes a practitioner from database with its id.
    @RequestMapping(path="/DeletePractitioner/", method = RequestMethod.GET)
    public ModelAndView deletePractitioner(@RequestParam(value = "ID", defaultValue = "null") String ID) {
        ModelAndView iMav = new ModelAndView();
        iMav.setViewName("DeletePractitioner");
        if(practitionerRepository.deletePractitioner(ID)) {
            System.out.println("a practitioner deleted");
            iMav.addObject("practitioners", practitionerRepository.findAllPractitioners());
            iMav.setViewName("bookSessionAdmin");
        }

        return iMav;
    }
    //This method looks up a practitioner by its last name.
    @RequestMapping(path="/LookUpPractitioner", method = RequestMethod.GET)
    public ModelAndView showResult(@RequestParam(value="lastName", defaultValue="null") String lastName) {
        ModelAndView iMav = new ModelAndView();
        iMav.addObject("practitioners", practitionerRepository.lookUpPractitioner(lastName));
        iMav.setViewName("bookSession");
        return iMav;
    }
    //Fetching all practitioners from database and show them in bookSession template.
    @RequestMapping(path="/ShowAllPractitioners", method = RequestMethod.GET)
    public ModelAndView showall(){
        ModelAndView iMav = new ModelAndView();
        iMav.addObject("practitioners", practitionerRepository.findAllPractitioners());
        iMav.setViewName("bookSession");
        return iMav;
    }
    //Fetching all practitioners from database and show them in bookSessionAdmin template if requested.
    @RequestMapping(path="/bookSessionAdmin")
    public ModelAndView showAllAdmin() {
        ModelAndView iMav = new ModelAndView();
        iMav.addObject("practitioners",practitionerRepository.findAllPractitioners());
        iMav.setViewName("bookSessionAdmin");
        return iMav;
    }
    //Fetching all practitioners from database and show them in bookSession template.
    @RequestMapping(path="/ShowAllPractitioners/Admin", method = RequestMethod.GET)
    public ModelAndView showallAdmin(){
        ModelAndView iMav = new ModelAndView();
        iMav.addObject("practitioners", practitionerRepository.findAllPractitioners());
        iMav.setViewName("bookSessionAdmin");
        return iMav;
    }
    /*
    This methods adds a user who wants to book online session with practitioners to database for
     future usage.The parameters come from a form called RequireHelp located in bookSession.html template.
    */
    @RequestMapping(path="/RequireHelp", method = RequestMethod.GET)
    public String requireHelp(@RequestParam(value="email", defaultValue="null") String email,
                                    @RequestParam(value="date", defaultValue="null") String date,
                                    @RequestParam(value = "time",defaultValue = "null") String time){
        //ModelAndView iMav = new ModelAndView();
        if(practitionerRepository.addRequireHelp(email,date,time))
        {
            System.out.print("success");
        }
        //go to the session page after success
        return "redirect:/session";
    }
    /*
            This methods adds information of a user who wants to send his/her story, in a database for
             future usage.The parameters come from a form called SendStory located in SendStory.html template.
    */
    @RequestMapping(path="/SendStory/", method = RequestMethod.GET)
    public String requireHelp(@RequestParam(value="name", defaultValue="null") String name,
                                    @RequestParam(value="email", defaultValue="null") String email,
                                    @RequestParam(value = "birth", defaultValue="null") String birth,
                                    @RequestParam(value = "link",defaultValue = "null") String link){
//        ModelAndView iMav = new ModelAndView();
        if(practitionerRepository.addStory(name,email,birth,link))
        {
            System.out.print("success");
        }
        //go to the session page after success
        return "redirect:/session";
    }

}
