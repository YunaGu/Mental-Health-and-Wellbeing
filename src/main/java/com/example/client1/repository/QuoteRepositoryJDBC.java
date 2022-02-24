package com.example.client1.repository;

import com.example.client1.DTO.QuotesDTO;
import com.example.client1.mapper.QuoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuoteRepositoryJDBC implements QuoteRepository {

    private final JdbcTemplate newJdbcTemplate;

    @Autowired
    public QuoteRepositoryJDBC(JdbcTemplate jdbcTemplate) {

        newJdbcTemplate = jdbcTemplate;
    }

    // Method to retrieve quotes data from daily_quotes mySQL table.

    @Override
    public List<QuotesDTO> displayAllQuotes() {
        return newJdbcTemplate.query(
                "select quotes, id from daily_quotes",
                new QuoteMapper());
    }

    // Method to add quotes to daily_quotes mySQL table.

//    @Override
//    public boolean addQuote(QuotesDTO quotesDTO) {
//        int rows = newJdbcTemplate.update("insert into daily_quotes (quotes) values(?)",
//                quotesDTO.getQuotes());
//        System.out.println("Quote Added!: " + quotesDTO.getQuotes());
//        return rows > 0;
//    }

    // Method to delete quotes from daily_quotes mySQL table.

    @Override
    public boolean deleteQuote(QuotesDTO quotesDTO) {
        int rows = newJdbcTemplate.update("delete from daily_quotes where id = ?",
                quotesDTO.getId());
        System.out.println("Quote Deleted!: " + quotesDTO.getId());
        return rows > 0;
    }
}
