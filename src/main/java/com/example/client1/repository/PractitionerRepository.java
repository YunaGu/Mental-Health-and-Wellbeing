package com.example.client1.repository;
import com.example.client1.form.AddPractitionerForm;

import java.util.Date;

/*
Create a repository Interface(PractitionerRepository) so the controller
 can call repository methods. If there was any change in database technology
 there is no need to change the interface methods. Just change the repository layer
*/
public interface PractitionerRepository {
    public Object findAllPractitioners();
    boolean addPractitioner(AddPractitionerForm addPractitionerForm);
    boolean deletePractitioner(String id);
    public Object lookUpPractitioner(String lastName);
    boolean addRequireHelp(String email, String date, String time);
    boolean addStory(String name, String email, String birth, String link);
}
