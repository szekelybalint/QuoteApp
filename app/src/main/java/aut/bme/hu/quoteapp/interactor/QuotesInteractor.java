package aut.bme.hu.quoteapp.interactor;

import android.os.AsyncTask;
import android.renderscript.ScriptIntrinsicYuvToRGB;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import aut.bme.hu.quoteapp.model.Quote;
import aut.bme.hu.quoteapp.model.QuotesResult;
import aut.bme.hu.quoteapp.network.QuoteApi;
import retrofit2.Call;

public class QuotesInteractor {
    QuoteApi quoteApi;

    @Inject
    public QuotesInteractor(QuoteApi quoteApi){
        this.quoteApi = quoteApi;
    }

    public QuotesResult getQuotes() throws IOException {
        Call<QuotesResult> getQuotesCall = quoteApi.getQuotes();
        return  getQuotesCall.execute().body();
    }

}
