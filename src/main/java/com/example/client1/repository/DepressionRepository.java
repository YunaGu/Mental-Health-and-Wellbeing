package com.example.client1.repository;

import com.example.client1.DTO.DepressionDTO;
import com.example.client1.mapper.DepressionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DepressionRepository {


        @Autowired
        private JdbcTemplate jdbcTemplate;

        @Transactional(readOnly = true)
        public List<DepressionDTO> getQues(){
            return jdbcTemplate.query("select * from depression", new DepressionMapper());
        }
}
