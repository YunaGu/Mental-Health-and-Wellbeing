package com.example.client1.DTO;
/*
DTOs or Data Transfer Objects are objects that carry data between processes in order
 to reduce the number of method calls. The repository transfers the result set to DTO(iframeDTO).
The DTO can then be passed to the model and view for display .
*/
public class iframeDTO {
    private int id;
    private String iframeName;
    private String link;
    //Constructor
    public iframeDTO(int id, String iframeName, String link) {
        this.id = id;
        this.iframeName = iframeName;
        this.link = link;
    }
    //getters
    public int getId() {
        return id;
    }

    public String getIframeName() {
        return iframeName;
    }

    public String getLink() {
        return link;
    }
}
