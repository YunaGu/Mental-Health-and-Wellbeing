package com.example.client1.Service;

import com.example.client1.DTO.NewsContent;

import java.util.List;

public interface NewsService {

    int addNews(NewsContent newsContent);

    List<NewsContent> getAll();

    int updateStateById(int id);

    List<NewsContent> search(String title, String authorName, int page, int num);

}
