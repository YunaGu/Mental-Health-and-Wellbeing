package com.example.client1.model;

import com.example.client1.DTO.PractitionerDTO;
import com.example.client1.DTO.iframeDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/*
iframeMapper class to transfer(map) sql results(rs) to DTO(Data Transfer Object)
called iframeDTO
*/

public class iframeMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        //Translate the result set to practitionerDTO object for the Template
        return new iframeDTO(rs.getInt("id"),
                rs.getString("iframeName"),
                rs.getString("link"));
    }
}
