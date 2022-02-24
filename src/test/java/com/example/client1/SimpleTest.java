package com.example.client1;


import com.example.client1.DTO.NewsContent;
import com.example.client1.Service.NewsService;
import com.example.client1.Utils.Result;
import com.example.client1.Utils.TimeTransfer;
import com.example.client1.controller.ResourceController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@SpringBootTest
public class SimpleTest {

    @Resource
    private NewsService newsService;

    @Resource
    private ResourceController resourceController;

    @Test
    public void DTO(){
        //To test whether the data can be output successfully or not
        TimeTransfer timeTransfer = new TimeTransfer();
        String transfer = timeTransfer.transfer(new Date());
        NewsContent newsContent = new NewsContent(1, "test", "test", null, "test", transfer);
        System.out.println(newsContent.toString());
    }

    @Test
    public void Service() {
        //To test whether the data can be added into database successfully or not
        TimeTransfer timeTransfer = new TimeTransfer();
        String transfer = timeTransfer.transfer(new Date());
        NewsContent newsContent = new NewsContent(1, "test", "test", null, "test", transfer);
        int i = newsService.addNews(newsContent);
        System.out.println(i);
    }

    @Test
    public void Controller() throws Exception {
        //To test resourceController(search)
        Result<List<NewsContent>> listResult = resourceController.search(null, null, null, null);
        for (NewsContent newsContent : listResult.getObject()) {
            System.out.println(newsContent.toString());
        }
    }
}


