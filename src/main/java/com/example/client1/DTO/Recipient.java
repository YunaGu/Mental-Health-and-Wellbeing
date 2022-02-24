package com.example.client1.DTO;

public class Recipient {

//    private int recipient_id;
    private String recipient_email;
    private String first_name;
    private String last_name;

    public Recipient( String recipient_email, String first_name, String last_name) {
//        this.recipient_id = recipient_id;
        this.recipient_email = recipient_email;
        this.first_name = first_name;
        this.last_name = last_name;
    }

//    public int getRecipient_id() {
//        return recipient_id;
//    }

    public String getRecipient_email() {
        return recipient_email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }
}
