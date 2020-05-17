package aut.bme.hu.quoteapp;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import aut.bme.hu.quoteapp.model.Quote;
import aut.bme.hu.quoteapp.model.QuoteEntity;
import aut.bme.hu.quoteapp.repository.DatabaseRepository;

public class MockRepository extends DatabaseRepository {

    public static List<QuoteEntity> table = new ArrayList<QuoteEntity>();

    public MockRepository(Context context) {
        super(context);

        QuoteEntity quote = new QuoteEntity();
        quote.setId(1);
        quote.setText("Ha nem gondolod azt, hogy bántalom ért, akkor nem is ért bántalom, s ha nem ért bántalom, akkor kárt sem szenvedtél.");
        quote.setAuthor("Marcus Aurelius");

        table.add(quote);
    }

    @Override
    public void insertQuote(final QuoteEntity quote) {
        table.add(quote);
    }

    @Override
    public List<QuoteEntity> getAllQuotes() {
        return table;
    }

    @Override
    public void DeleteQuote(final QuoteEntity quote) {
        table.removeIf(q -> q.getId() == quote.getId());
    }
}