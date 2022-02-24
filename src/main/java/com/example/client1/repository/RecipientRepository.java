package com.example.client1.repository;

import com.example.client1.DTO.Recipient;

public interface RecipientRepository {
    public Object findAllRecipients();
    boolean signupRecipient(Recipient recipient);

}
