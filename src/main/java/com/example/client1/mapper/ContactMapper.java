package com.example.client1.mapper;

//import com.example.client1.Contact;

import com.example.client1.DTO.Contact;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

//public class ContactMapper {

    public class ContactMapper implements RowMapper {
        @Override
        public Object mapRow(ResultSet ps, int rowNum) throws SQLException {
            return new Contact(
                    ps.getString("firstName"),
                    ps.getString("lastName"),
                    ps.getString("email"),
                    ps.getString("message")
            );
        }
    }





