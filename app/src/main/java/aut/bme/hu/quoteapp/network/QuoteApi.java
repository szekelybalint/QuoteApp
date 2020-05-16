package aut.bme.hu.quoteapp.network;

import java.util.List;

import aut.bme.hu.quoteapp.model.Quote;
import aut.bme.hu.quoteapp.model.QuotesResult;
import retrofit2.Call;
import retrofit2.http.GET;

public interface QuoteApi {
    @GET("5ebebf4f3100004c00c5d567")
    Call<QuotesResult> getQuotes();
}
