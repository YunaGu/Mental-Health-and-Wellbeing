package com.example.client1.repository;
import com.example.client1.DTO.PractitionerDTO;
import com.example.client1.form.AddPractitionerForm;
import com.example.client1.model.PractitionerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

//the repository layer implementation using JDBC
@Repository
public class PractitionerRepositoryJDBC implements PractitionerRepository {

    private JdbcTemplate myJdbcTemplate;
    /*
        Autowired means that when framework compiles the server code, it registers this instance of the PractitionerRepository created
        by the framework and will use it when needed . The framework creates and passes in the JDBCTemplate the repository implementation
         is created via the constructor.
    */
    @Autowired
    public PractitionerRepositoryJDBC(JdbcTemplate jdbcTemplate) {

        myJdbcTemplate = jdbcTemplate;
    }
    /*
        @Override annotation informs the compiler that the element is meant
        to override an element declared in a superclass
    */
    @Override
    //method to find all practitioners from the table with the same name in mysql database
    public List<PractitionerDTO> findAllPractitioners() {
        return myJdbcTemplate.query(
                "select ID,firstName,lastName,email,status from Practitioners where status='True'" ,
                new PractitionerMapper());
    }

    @Override
    //method to add a practitioner to database
    public boolean addPractitioner(AddPractitionerForm addPractitionerForm) {
        int rows = myJdbcTemplate.update(
                "insert into Practitioners (firstName,lastName,email,status) values(?,?,?,?)" ,
                new Object[]{addPractitionerForm.getFirstName(), addPractitionerForm.getLastName(),
                        addPractitionerForm.getEmail(), addPractitionerForm.getStatus()});
        return rows>0;
    }
    @Override
    //method to delete a practitioner from database
    public boolean deletePractitioner(String id){
        int rows=myJdbcTemplate.update(
                "delete from Practitioners where ID = ?" ,
                new Object[]{ id});
        return rows>0;

    }
    @Override
    //method to search practitioners from database with Surname
    public List<PractitionerDTO> lookUpPractitioner(String lastName) {
        return myJdbcTemplate.query(
                "select ID,firstName,lastName,email,status from Practitioners where lastName=? and status='true'",
                new Object[]{lastName}, new PractitionerMapper());

    }
    @Override
    /*
    method to add people who send their request from bookSession.html page,
     in mysql database(helprequest table)
    */
    public boolean addRequireHelp(String email, String date, String time) {
        int rows = myJdbcTemplate.update(
                "insert into helprequest (email, date, time) values(?,?,?)" ,
                new Object[]{email, date, time});
        return rows>0;
    }
    /*
        method to add people who send their stories from SendStory.html page,
         in mysql database(stories table)
    */
    @Override
    public boolean addStory(String name, String email, String birth, String link){
        int rows = myJdbcTemplate.update(
                "insert into stories (name, email, birth, link) values(?,?,?,?)" ,
                new Object[]{name, email, birth, link});
        return rows>0;

    }




}
