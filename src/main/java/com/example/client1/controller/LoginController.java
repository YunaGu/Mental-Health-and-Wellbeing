package com.example.client1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginController {
    @RequestMapping("/admin/login")
    public String Login() {
        return "login";
    }

    @RequestMapping("/admin/news/add")
    public String AddContentPageForAdmin() {
        return "addContentPageForAdmin";
    }

    @RequestMapping("/admin/news/search")
    public String Search() {
        return "search";
    }

    @RequestMapping("/admin/news/select")
    public String page() {
        return "select";
    }

}
