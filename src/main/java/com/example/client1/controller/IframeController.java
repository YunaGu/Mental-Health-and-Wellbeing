package com.example.client1.controller;

import com.example.client1.repository.IframeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
/*
In MVC the access to the database returns some data from storage in
the form of a ResultSet, The controller needs to pass a data object
and a template to the view layer (Thymeleaf).
IframeController process requests and organise data collection.
*/

@Controller
public class IframeController {
    private IframeRepository iframeRepository;

    /*
    Autowired means that when framework compiles the server code, it registers this instance of the IframeRepository created
    by the framework and will use it when needed .
*/
    @Autowired
    public IframeController(IframeRepository iRepo) {
        iframeRepository = iRepo;
    }
    /*
    @RequestMapping Annotation for mapping web requests(e.g. /session) onto methods (e.g session()).
    This method finds an iframe from database and sends it to view layer.
    with iMav(Model and view object)
    */
    @RequestMapping(path="/session", method = RequestMethod.GET)
    public ModelAndView session() {
        ModelAndView iMav = new ModelAndView();
        iMav.addObject("iframes", iframeRepository.findAllIframes());
        iMav.setViewName("session");
        return iMav;
    }
//    @RequestMapping(path="/SessionAdmin")
//    public ModelAndView sessionAdmin1() {
//        ModelAndView iMav = new ModelAndView();
//        iMav.addObject("iframes", iframeRepository.findAllIframes());
//        iMav.setViewName("SessionAdmin");
//        return iMav;
//    }
    @RequestMapping(path="/SessionAdmin", method = RequestMethod.GET)
    public ModelAndView sessionAdmin() {
        ModelAndView iMav = new ModelAndView();
        iMav.addObject("iframes", iframeRepository.findAllIframes());
        iMav.setViewName("SessionAdmin");
        return iMav;
    }
    //this method updates an iframe link in the database
    @RequestMapping(path="/UpdateIframe1", method = RequestMethod.GET)
    public ModelAndView UpdateIframe1(@RequestParam(value="newLink", defaultValue="null") String newLink){
        ModelAndView iMav = new ModelAndView();
        if(iframeRepository.updateIframe("1",newLink))
        {
            System.out.print("success");
        }
        iMav.addObject("iframes", iframeRepository.findAllIframes());
        //go to the session page at the next step
        iMav.setViewName("SessionAdmin");
        return iMav;
    }
    //this method updates an iframe link in the database
    @RequestMapping(path="/UpdateIframe2", method = RequestMethod.GET)
    public ModelAndView UpdateIframe2(@RequestParam(value="newLink", defaultValue="null") String newLink){
        ModelAndView iMav = new ModelAndView();
        if(iframeRepository.updateIframe("2",newLink))
        {
            System.out.print("success");
        }
        iMav.addObject("iframes", iframeRepository.findAllIframes());
        //go to the session page at the next step
        iMav.setViewName("SessionAdmin");
        return iMav;

    }
    //this method updates an iframe link in the database
    @RequestMapping(path="/UpdateIframe3", method = RequestMethod.GET)
    public ModelAndView UpdateIframe3(@RequestParam(value="newLink", defaultValue="null") String newLink){
        ModelAndView iMav = new ModelAndView();
        if(iframeRepository.updateIframe("3",newLink))
        {
            System.out.print("success");
        }
        iMav.addObject("iframes", iframeRepository.findAllIframes());
        //go to the session page at the next step
        iMav.setViewName("SessionAdmin");
        return iMav;
    }
    //this method updates an iframe link in the database
    @RequestMapping(path="/UpdateIframe4", method = RequestMethod.GET)
    public ModelAndView UpdateIframe4(@RequestParam(value="newLink", defaultValue="null") String newLink){
        ModelAndView iMav = new ModelAndView();
        if(iframeRepository.updateIframe("4",newLink))
        {
            System.out.print("success");
        }
        iMav.addObject("iframes", iframeRepository.findAllIframes());
        //go to the session page at the next step
        iMav.setViewName("SessionAdmin");
        return iMav;
    }
    //this method updates an iframe link in the database
    @RequestMapping(path="/UpdateIframe5", method = RequestMethod.GET)
    public ModelAndView UpdateIframe5(@RequestParam(value="newLink", defaultValue="null") String newLink){
        ModelAndView iMav = new ModelAndView();
        if(iframeRepository.updateIframe("5",newLink))
        {
            System.out.print("success");
        }
        iMav.addObject("iframes", iframeRepository.findAllIframes());
        //go to the session page at the next step
        iMav.setViewName("SessionAdmin");
        return iMav;
    }
    //this method updates an iframe link in the database
    @RequestMapping(path="/UpdateIframe6", method = RequestMethod.GET)
    public ModelAndView UpdateIframe6(@RequestParam(value="newLink", defaultValue="null") String newLink){
        ModelAndView iMav = new ModelAndView();
        if(iframeRepository.updateIframe("6",newLink))
        {
            System.out.print("success");
        }
        iMav.addObject("iframes", iframeRepository.findAllIframes());
        //go to the session page at the next step
        iMav.setViewName("SessionAdmin");
        return iMav;
    }
    //this method updates an iframe link in the database
    @RequestMapping(path="/UpdateIframe7", method = RequestMethod.GET)
    public ModelAndView UpdateIframe7(@RequestParam(value="newLink", defaultValue="null") String newLink){
        ModelAndView iMav = new ModelAndView();
        if(iframeRepository.updateIframe("7",newLink))
        {
            System.out.print("success");
        }
        iMav.addObject("iframes", iframeRepository.findAllIframes());
        //go to the session page at the next step
        iMav.setViewName("SessionAdmin");
        return iMav;
    }
    //this method updates an iframe link in the database
    @RequestMapping(path="/UpdateIframe8", method = RequestMethod.GET)
    public ModelAndView UpdateIframe8(@RequestParam(value="newLink", defaultValue="null") String newLink){
        ModelAndView iMav = new ModelAndView();
        if(iframeRepository.updateIframe("8",newLink))
        {
            System.out.print("success");
        }
        iMav.addObject("iframes", iframeRepository.findAllIframes());
        //go to the session page at the next step
        iMav.setViewName("SessionAdmin");
        return iMav;
    }
    //this method updates an iframe link in the database
    @RequestMapping(path="/UpdateIframe9", method = RequestMethod.GET)
    public ModelAndView UpdateIframe9(@RequestParam(value="newLink", defaultValue="null") String newLink){
        ModelAndView iMav = new ModelAndView();
        if(iframeRepository.updateIframe("9",newLink))
        {
            System.out.print("success");
        }
        iMav.addObject("iframes", iframeRepository.findAllIframes());
        //go to the session page at the next step
        iMav.setViewName("SessionAdmin");
        return iMav;
    }

}
