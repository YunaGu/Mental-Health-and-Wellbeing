package com.example.client1.DTO;

public class MemberDTO {
    private int user_ID;
    private String username;
    private String password;

    public MemberDTO(int user_ID, String username, String password) {
        this.user_ID = user_ID;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getUser_ID() {
        return user_ID;
    }
}
