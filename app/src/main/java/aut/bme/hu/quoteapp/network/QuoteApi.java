package aut.bme.hu.quoteapp.network;

import java.util.List;

import aut.bme.hu.quoteapp.model.Quote;
import aut.bme.hu.quoteapp.model.QuotesResult;
import retrofit2.Call;
import retrofit2.http.GET;

public interface QuoteApi {
    @GET("5ec1a2f12f00000e00c34d87")
    Call<QuotesResult> getQuotes();
}
