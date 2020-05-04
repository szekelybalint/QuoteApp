package aut.bme.hu.quoteapp.model;

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

    private String QuoteAuthor;
    private String QuoteText;
}
