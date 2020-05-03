package aut.bme.hu.quoteapp.mock;

import aut.bme.hu.quoteapp.model.QuotesResult;
import aut.bme.hu.quoteapp.network.QuoteApi;
import retrofit2.Call;

public class MockQuoteApi implements QuoteApi {
    @Override
    public Call<QuotesResult> getQuotes() {
        return null;
    }
}
