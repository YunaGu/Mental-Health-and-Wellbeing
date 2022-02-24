package com.example.client1.DTO;

public class NewsContent {
    private int id;
    private String title;
    private String authorName;
    private String image;
    private String uploadTime;
    private String text;
    private int state;

    public NewsContent(int id, String title, String authorName, String image, String text , String uploadTime) {
        this.id = id;
        this.title = title;
        this.authorName = authorName;
        this.image = image;
        this.text = text;
        this.uploadTime = uploadTime;

    }

    @Override
    public String toString() {
        return "NewsContent{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authorName='" + authorName + '\'' +
                ", image='" + image + '\'' +
                ", uploadTime='" + uploadTime + '\'' +
                ", text='" + text + '\'' +
                ", state=" + state +
                '}';
    }

    public NewsContent() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

}
