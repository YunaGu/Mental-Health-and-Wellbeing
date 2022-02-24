package com.example.client1.controller;

import com.example.client1.DTO.NewsContent;
import com.example.client1.Service.Impl.NewsServiceImpl;
import com.example.client1.Service.NewsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminDeleteNewsController {
    private NewsService repo;

    public AdminDeleteNewsController(NewsService repo) {
        this.repo = repo;
    }

    @RequestMapping(path = "/admin/news/delete")
    public String news(Model view)
    {
        view.addAttribute("list", repo.getAll());
        view.addAttribute("news", new NewsContent());
        return "deleteContentPageForAdmin";
    }

}
