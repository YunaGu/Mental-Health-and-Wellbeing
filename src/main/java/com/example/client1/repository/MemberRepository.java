package com.example.client1.repository;


import com.example.client1.DTO.MemberDTO;
import com.example.client1.form.RegisterForm;

//Interface that simple calls methods made in the repository class
public interface MemberRepository {
    public Object findAllMembers();

    boolean addMember(RegisterForm registerForm);

    boolean deleteMember(MemberDTO memberDTO);
}
