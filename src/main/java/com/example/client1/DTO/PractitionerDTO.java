package com.example.client1.DTO;
/*
DTOs or Data Transfer Objects are objects that carry data between processes in order
 to reduce the number of method calls. The repository transfers the result set to DTO(PractitionerDTO).
The DTO can then be passed to the template for display .
*/
public class PractitionerDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private boolean status;

    //constructor
    public PractitionerDTO(int id, String firstName, String lastName, String email, boolean status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public boolean getStatus() {
        return status;
    }
}
