package aut.bme.hu.quoteapp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import aut.bme.hu.quoteapp.model.Quote;
import aut.bme.hu.quoteapp.model.QuotesResult;
import aut.bme.hu.quoteapp.network.QuoteApi;
import okhttp3.Request;
import okio.Timeout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MockQuoteApi implements QuoteApi {
    @Override
    public Call<QuotesResult> getQuotes() {

        Quote quote = new Quote();
        quote.setQuoteText("Ha nem gondolod azt, hogy bántalom ért, akkor nem is ért bántalom, s ha nem ért bántalom, akkor kárt sem szenvedtél.");
        quote.setQuoteAuthor("Marcus Aurelius");

        List<Quote> quotesList = new ArrayList<Quote>();
        quotesList.add(quote);

        QuotesResult quotesResult = new QuotesResult();
        quotesResult.setQuotes(quotesList);

        Call<QuotesResult> call = new Call<QuotesResult>(){

            @Override
            public Response<QuotesResult> execute() throws IOException {
                return Response.success(quotesResult);
            }

            @Override
            public void enqueue(Callback<QuotesResult> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<QuotesResult> clone() {
                return null;
            }

            @Override
            public Request request() {
                return null;
            }

            @Override
            public Timeout timeout() {
                return null;
            }
        };

        return call;
    }
}
