package com.example.client1.mapper;

import com.example.client1.DTO.QuotesDTO;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuoteMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet ps2, int rowNum) throws SQLException {
        return new QuotesDTO(
                ps2.getInt("id"),
                ps2.getString("quotes")
        );
    }
}