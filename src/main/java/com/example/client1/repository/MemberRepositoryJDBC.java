package com.example.client1.repository;

import com.example.client1.DTO.MemberDTO;
import com.example.client1.form.RegisterForm;
import com.example.client1.model.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepositoryJDBC implements MemberRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MemberRepositoryJDBC(JdbcTemplate aTemplate) {
        jdbcTemplate = aTemplate;
    }

    //Method with override annotation for retrieving information from database table
    @Override
    public List<MemberDTO> findAllMembers() {
        return jdbcTemplate.query(
                "select user_ID, username, password, role, enabled from users",
                new MemberMapper());
    }

    //    Method with override annotation for adding member to users table in database using RegisterForm class
//    using jdbctemplate & update to add "member" role & "1" enabled status by default and using getters to retrieve user input from RegisterForm
    @Override
    public boolean addMember(RegisterForm registerForm) {
        int rows = jdbcTemplate.update(
                "insert into users (username,password,role,enabled) values(?,?,'ROLE_MEMBER',1)",
                registerForm.getUsername(), registerForm.getPassword());
        return rows > 0;
    }

    //    Method for deleting a member from the users table using MemberDTO
//    Outputs id of deleted user to console
    @Override
    public boolean deleteMember(MemberDTO memberDTO) {
        int rows = jdbcTemplate.update("delete from users where user_ID = ?",
                memberDTO.getUser_ID());
        System.out.println("Deleted user: " + memberDTO.getUser_ID());
        return rows > 0;
    }
}
