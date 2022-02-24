package com.example.client1.mapper;

import com.example.client1.DTO.DepressionDTO;
import com.example.client1.DTO.Quiz;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepressionMapper implements RowMapper<DepressionDTO> {

    public DepressionDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        DepressionDTO depression = new DepressionDTO();
        depression.setId(rs.getInt("id"));
        depression.setQuestion(rs.getString("question"));
        depression.setOptionA(rs.getString("optionA"));
        depression.setOptionB(rs.getString("optionB"));
        depression.setOptionC(rs.getString("optionC"));
        depression.setOptionD(rs.getString("optionD"));
        return depression;

    }
}