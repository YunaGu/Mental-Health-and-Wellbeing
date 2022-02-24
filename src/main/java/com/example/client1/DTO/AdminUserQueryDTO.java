package com.example.client1.DTO;

public class AdminUserQueryDTO {

    public AdminUserQueryDTO(int ID, String firstname, String lastname, String email, String message) {
        this.ID = ID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.message = message;
    }

    private Integer ID;
    private String firstname;
    private String lastname;
    private String email;
    private String message;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "AdminUserQueryDTO{" +
                "ID='" + ID + '\'' +
                ",firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}





