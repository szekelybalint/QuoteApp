package aut.bme.hu.quoteapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Quote {
    public String getAuthor() {
        return QuoteAuthor;
    }

    public void setQuoteAuthor(String author) {
        QuoteAuthor = author;
    }

    public String getQuoteText() {
        return QuoteText;
    }

    public void setQuoteText(String text) {
        QuoteText = text;
    }

    @Expose
    @SerializedName("quoteAuthor")
    private String QuoteAuthor;

    @Expose
    @SerializedName("quoteText")
    private String QuoteText;
}
