package com.example.client1.model;

import com.example.client1.DTO.MemberDTO;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException{
        return new MemberDTO(rs.getInt("user_ID"),
                rs.getString("username"),
                rs.getString("password"));

    }
}
