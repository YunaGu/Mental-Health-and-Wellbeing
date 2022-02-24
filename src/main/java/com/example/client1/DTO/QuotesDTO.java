package com.example.client1.DTO;

public class QuotesDTO {

    public QuotesDTO(int id, String quotes) {
        this.id = id;
        this.quotes = quotes;
    }

    private int id;
    private String quotes;

    public int getId() {
        return id;
    }

    public String getQuotes() {
        return quotes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuotes(String quotes) {
        this.quotes = quotes;
    }

    @Override
    public String toString() {
        return "QuotesDTO{" +
                "id=" + id +
                ", quotes='" + quotes + '\'' +
                '}';
    }
}
