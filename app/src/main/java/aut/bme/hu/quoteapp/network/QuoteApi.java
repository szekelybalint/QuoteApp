package aut.bme.hu.quoteapp.network;

import java.util.List;

import aut.bme.hu.quoteapp.model.Quote;

public interface QuoteApi {
    List<Quote> getQuotes();
}
