package com.example.client1.repository;

import com.example.client1.DTO.AdminUserQueryDTO;
import com.example.client1.mapper.AdminQueryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminQueryRepositoryJDBC implements AdminQueryRepository{

    private final JdbcTemplate newJdbcTemplate;

    @Autowired
    public AdminQueryRepositoryJDBC(JdbcTemplate jdbcTemplate) {

        newJdbcTemplate = jdbcTemplate;
    }

    // Method to retrieve data from mySQL table in charity database.

    @Override
    public List<AdminUserQueryDTO> displayAllQueries() {
        return newJdbcTemplate.query(
                "select firstname, lastname, email, message, ID from userquery",
                new AdminQueryMapper());
    }
}


