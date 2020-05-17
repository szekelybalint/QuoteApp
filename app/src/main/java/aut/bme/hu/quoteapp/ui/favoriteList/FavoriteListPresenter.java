package aut.bme.hu.quoteapp.ui.favoriteList;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import aut.bme.hu.quoteapp.interactor.QuotesInteractor;
import aut.bme.hu.quoteapp.model.Quote;
import aut.bme.hu.quoteapp.model.QuoteEntity;
import aut.bme.hu.quoteapp.repository.DatabaseRepository;
import aut.bme.hu.quoteapp.ui.Presenter;
import aut.bme.hu.quoteapp.ui.quoteList.QuoteListScreen;

public class FavoriteListPresenter extends Presenter<FavoriteListScreen> {

    List<QuoteEntity> quotes = new ArrayList<QuoteEntity>();

    @Inject
    DatabaseRepository repository;

    @Inject
    public FavoriteListPresenter(DatabaseRepository repository){
        this.repository = repository;
    }

    public void getQuotesFromDatabase(){
        List<QuoteEntity> quoteEntities = repository.getAllQuotes();

        screen.showQuotes(quoteEntities);
    }

    public void deleteFromDatabase(int id){
        QuoteEntity q = new QuoteEntity();
        q.setId(id);
        repository.DeleteQuote(q);
        getQuotesFromDatabase();
    }
}
