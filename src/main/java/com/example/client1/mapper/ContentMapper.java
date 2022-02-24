package com.example.client1.mapper;

import com.example.client1.DTO.NewsContent;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * mapper
 */
public class ContentMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new NewsContent(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("authorName"),
                rs.getString("image"),
                rs.getString("text"),
                rs.getString("uploadTime")
        );


    }
}
