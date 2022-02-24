package com.example.client1.mapper;


import com.example.client1.DTO.Quiz;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuizRowMapper implements RowMapper<Quiz> {
    public Quiz mapRow(ResultSet rs, int rowNum) throws SQLException {
        Quiz quiz = new Quiz();
        quiz.setId(rs.getInt("id"));
        quiz.setQuestion(rs.getString("question"));
        quiz.setOptionA(rs.getString("optionA"));
        quiz.setOptionB(rs.getString("optionB"));
        quiz.setOptionC(rs.getString("optionC"));
        quiz.setOptionD(rs.getString("optionD"));
        quiz.setOptionE(rs.getString("optionE"));
        return quiz;
    }
}

