package com.example.client1.controller;

import com.example.client1.DTO.NewsContent;
import com.example.client1.Service.NewsService;
import com.example.client1.Utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * rest controller
 */
@RestController
// Annotation for process request address mapping
@RequestMapping("/news")
public class ResourceController {
    @Resource
    private NewsService newsService;

    /**
     *
     * @param newsContent
     * @return
     */
    //add resource
    @PostMapping("/add")
    public Result<Integer> addNews(@RequestBody NewsContent newsContent) {
        // eg: 1 indicates that the data has been added into database
        int i = newsService.addNews(newsContent);
        if (i == 1) {
            return new Result<Integer>("200", "successful", i);
        } else {
            return new Result<Integer>("400", "failed", i);
        }
    }

    /**
     *
     * @param newsId
     * @return message
     */
    //delete resource
    @GetMapping(path = "/delete/{newsId}")
    public String delete(@PathVariable int newsId) {
        //  update state by id(logical deletion)
        int i = newsService.updateStateById(newsId);
        if (i == 1) {
            return " Delete successful";
        } else {
            return " Delete failed";
        }
    }

    /**
     *
     * @param title
     * @param authorName
     * @param page
     * @param num
     * @return
     * @throws Exception
     */
    //Search resource
    @GetMapping("/search")
    public Result<List<NewsContent>> search(String title, String authorName, Integer page, Integer num) throws Exception {
        // paging
        if (page == null) {
            page = 0;
        }
        if (num == null) {
            num = 10;
        }
        List<NewsContent> newsContents = new ArrayList<NewsContent>();
        newsContents = newsService.search(title, authorName, page, num);
        System.out.println(newsContents);
        if (newsContents != null) {
            return new Result<List<NewsContent>>("200", "query successful", newsContents);
        } else {
            return new Result<List<NewsContent>>("400", "query failed", newsContents);
        }
    }
}






