package com.example.client1.repository;

import com.example.client1.DTO.QuotesDTO;

public interface QuoteRepository {

    public Object displayAllQuotes();

//    boolean addQuote(QuotesDTO quotesDTO);

    boolean deleteQuote(QuotesDTO quotesDTO);

    }


