package aut.bme.hu.quoteapp.model;

public class Quote {
    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    private String Author;
    private String Text;
}
