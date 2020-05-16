package aut.bme.hu.quoteapp.repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.inject.Inject;

import aut.bme.hu.quoteapp.QuotesApplication;
import aut.bme.hu.quoteapp.model.Quote;
import aut.bme.hu.quoteapp.model.QuoteEntity;

public class DatabaseRepository {

    @Inject
    Context context;

    private QuoteDatabase quoteDatabase;

    @Inject
    public DatabaseRepository(Context context){
        quoteDatabase = Room.databaseBuilder(context, QuoteDatabase.class, "db_quotes").build();
    }

    public void insertQuote(final QuoteEntity quote){
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... voids){
                quoteDatabase.daoAccess().insertQuote(quote);
                return null;
            }
        }.execute();
    }

    public List<QuoteEntity> getAllQuotes(){
        try {
            return new AsyncTask<Void, Void, List<QuoteEntity>>() {
                @Override
                protected List<QuoteEntity> doInBackground(Void... voids) {
                    return quoteDatabase.daoAccess().getAllQuotes();
                }
            }.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public void DeleteQuote(final QuoteEntity quote){
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... voids){
                quoteDatabase.daoAccess().deleteQuote(quote);
                return null;
            }
        }.execute();
    }
}
