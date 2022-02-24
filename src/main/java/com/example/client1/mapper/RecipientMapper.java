package com.example.client1.mapper;


import com.example.client1.form.RecipientForm;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecipientMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException{
        return new RecipientForm(rs.getInt("recipient_id"),
                rs.getString("recipient_email"),
                rs.getString("first_name"),
                rs.getString("last_name"));

    }
}
