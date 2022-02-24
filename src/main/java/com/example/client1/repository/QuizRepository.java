package com.example.client1.repository;

import com.example.client1.DTO.Quiz;
import com.example.client1.mapper.QuizRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class QuizRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(readOnly = true)
    public List<Quiz> getQuiz(){
        return jdbcTemplate.query("select * from QUIZ", new QuizRowMapper());
    }

}
