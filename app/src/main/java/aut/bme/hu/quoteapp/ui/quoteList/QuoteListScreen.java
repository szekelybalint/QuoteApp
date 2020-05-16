package aut.bme.hu.quoteapp.ui.quoteList;

import java.util.List;

import aut.bme.hu.quoteapp.model.Quote;

public interface QuoteListScreen {
    void showQuotes(List<Quote> quoteList);
}
