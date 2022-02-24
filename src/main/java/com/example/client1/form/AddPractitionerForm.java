package com.example.client1.form;

public class AddPractitionerForm {
    private String firstName;
    private String lastName;
    private String email;
    private String status;

    public AddPractitionerForm(String firstName, String lastName, String email, String status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.status = status;
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

    public String getStatus() {
        return status;
    }
}
