package aut.bme.hu.quoteapp.ui.quoteList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import aut.bme.hu.quoteapp.interactor.QuotesInteractor;
import aut.bme.hu.quoteapp.model.Quote;
import aut.bme.hu.quoteapp.model.QuoteEntity;
import aut.bme.hu.quoteapp.repository.DatabaseRepository;
import aut.bme.hu.quoteapp.ui.Presenter;

public class QuoteListPresenter extends Presenter<QuoteListScreen> {

    List<Quote> quotes = new ArrayList<Quote>();

    @Inject
    QuotesInteractor interactor;

    @Inject
    DatabaseRepository repository;

    @Inject
    public QuoteListPresenter(QuotesInteractor quotesInteractor, DatabaseRepository repository){
        this.interactor = quotesInteractor;
        this.repository = repository;
    }

    public void getQuotesFromInteractor() throws IOException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try  {
                    //Your code goes here
                    quotes = interactor.getQuotes().getQuotes();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        screen.showQuotes(quotes);
    }

    public void getQuotesFromDatabase(){
        List<QuoteEntity> quoteEntities = repository.getAllQuotes();

        List<Quote> quoteList = new ArrayList<Quote>();

        for (QuoteEntity q : quoteEntities)
        {
            Quote quote = new Quote();
            quote.setQuoteAuthor(q.getAuthor());
            quote.setQuoteText(q.getText());
        }

        screen.showQuotes(quoteList);
    }

    public void addFavorite(int quoteIndex){
        int valami = 10;
        QuoteEntity entity = new QuoteEntity();
        entity.setAuthor(quotes.get(quoteIndex).getAuthor());
        entity.setText(quotes.get(quoteIndex).getQuoteText());
        repository.insertQuote(entity);
    }
}
