package com.example.client1.mapper;

import com.example.client1.DTO.AdminUserQueryDTO;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminQueryMapper implements RowMapper{

    @Override
    public Object mapRow(ResultSet ps3, int rowNum) throws SQLException {
        return new AdminUserQueryDTO(
                ps3.getInt("ID"),
                ps3.getString("firstname"),
                ps3.getString("lastname"),
                ps3.getString("email"),
                ps3.getString("message")
        );
    }
}