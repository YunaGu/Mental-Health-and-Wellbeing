package com.example.client1.repository;

import com.example.client1.DTO.Recipient;
import com.example.client1.form.RecipientForm;
import com.example.client1.mapper.RecipientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecipientRepositoryJDBC implements RecipientRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RecipientRepositoryJDBC(JdbcTemplate aTemplate) {
        jdbcTemplate = aTemplate;
    }

    //Method with override annotation for retrieving information from database table
    @Override
    public List<RecipientForm> findAllRecipients() {
        return jdbcTemplate.query(
                "select recipient_id, recipient_email, first_name, last_name from charity.recipients",
                new RecipientMapper());
    }

    @Override
    public boolean signupRecipient(Recipient recipient) {
        int rows = jdbcTemplate.update(
                "insert into recipients (recipient_email, first_name, last_name) values(?,?,?)",
                recipient.getRecipient_email(), recipient.getFirst_name(), recipient.getLast_name());
        return rows>0;
    }
}