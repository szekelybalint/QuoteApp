package aut.bme.hu.quoteapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuotesResult {
    @SerializedName("quotes")
    @Expose
    private List<Quote> quotes;

    /**
     * @return The quotes
     */
    public List<Quote> getQuotes() {
        return quotes;
    }

    /**
     * @param quotes list of quotes
     */
    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }
}
