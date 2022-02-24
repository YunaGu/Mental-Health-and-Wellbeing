package com.example.client1.model;
import com.example.client1.DTO.PractitionerDTO;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
/*
PractitionerMapper class to transfer sql results to DTO(Data Transfer Object)
called PractitionerDTO
*/
public class PractitionerMapper implements RowMapper {
    /*
            @Override annotation informs the compiler that the element is meant
            to override an element declared in a superclass
     */
    @Override
    public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        //Translate the result set to practitionerDTO object for the Template
        return new PractitionerDTO(resultSet.getInt("ID"),
                resultSet.getString("firstName"),
                resultSet.getString("lastName"),
                resultSet.getString("email"),
                resultSet.getBoolean("status"));
    }
}
