package com.example.client1.repository;

import com.example.client1.DTO.PractitionerDTO;
import com.example.client1.DTO.iframeDTO;
import com.example.client1.model.PractitionerMapper;
import com.example.client1.model.iframeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IframeRepositoryJDBC implements IframeRepository {

    private JdbcTemplate myJdbcTemplate;
    /*
        Autowired means that when framework compiles the server code, it registers this instance of the iframeRepository created
        by the framework and will use it when needed .
    */
    @Autowired
    public IframeRepositoryJDBC(JdbcTemplate jdbcTemplate) {

        myJdbcTemplate = jdbcTemplate;
    }
    /*
        @Override annotation informs the compiler that the element is meant
        to override an element declared in a superclass
    */
    @Override
    //method to find an iframe from database with iframeName
    public List<iframeDTO> findAllIframes() {
        return myJdbcTemplate.query(
                "select id,iframeName,link from iframes" ,
                new iframeMapper()); }

    @Override
    //method to search iframe from database with iframeName
    public iframeDTO findIframe(String iframeName) {
        return (iframeDTO) myJdbcTemplate.query(
                "select id,iframeName,link from iframes where iframeName=?",
                new Object[]{iframeName}, new iframeMapper());

    }
    @Override
    //method to update link of existing iframe in the database with iframeName key
    public boolean updateIframe(String frameName,String newLink) {
        int rows = myJdbcTemplate.update(
                "update iframes set link=? where iframeName=?" ,
                new Object[]{newLink,frameName});
        return rows>0;
    }

}
