package com.example.client1.Service.Impl;

import com.example.client1.DTO.NewsContent;
import com.example.client1.Service.NewsService;
import com.example.client1.Utils.TimeTransfer;
import com.example.client1.mapper.ContentMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Repository
public class NewsServiceImpl implements NewsService {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Resource
    private TimeTransfer timeTransfer;

    @Override
    public int addNews(NewsContent newsContent) {
        newsContent.setUploadTime(timeTransfer.transfer(new Date()));
        int i = jdbcTemplate.update("insert into news_content (title,authorName,image,text,uploadTime, state) values(?, ?, ?, ?, ?, 1)",
                new Object[]{newsContent.getTitle(), newsContent.getAuthorName(), newsContent.getImage(),
                        newsContent.getText(), newsContent.getUploadTime()});

        return i;
    }

    @Override
    public int updateStateById(int id) {
        int state = 0;
        // logical deletion, change the state is 0
        int i = jdbcTemplate.update("update news_content set state = ?, deleteTime = ? where id = ?",
                new Object[]{state, timeTransfer.transfer(new Date()), id});

        return i;
    }

    @Override
    public List<NewsContent> search(String title, String authorName, int page, int num) {
        // paging
        page = (page - 1) * num;
        if (page < 0) {
            page = 0;
        }
        // define a new ArrayList to store params(title,authorName,page,num)
        List objects = new ArrayList();
        // using StringBuffer to optimize string
        StringBuffer sql = new StringBuffer("select id, title, authorName, image, text, uploadTime,deleteTime from news_content where state = '1' ");
        // string splicing and fuzzy query
        if (title != null && title != "") {
            sql.append("and title like ? ");
            title = "%" + title + "%";
            objects.add(title);
        }
        if (authorName != null && authorName != "") {
            sql.append("and authorName like ? ");
            authorName = "%" + authorName + "%";
            objects.add(authorName);
        }
        // paging string splicing
        sql.append("order by uploadTime desc limit ?, ?");
        objects.add(page);
        objects.add(num);
        return jdbcTemplate.query(sql.toString(), objects.toArray(), new ContentMapper());
    }

    @Override
    public List<NewsContent> getAll() {
        return jdbcTemplate.query("select id, title, authorName, image, text, uploadTime,state from news_content where state = '1'", new ContentMapper());

    }
}
