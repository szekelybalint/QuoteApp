package aut.bme.hu.quoteapp.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class QuoteEntity {
    public QuoteEntity(){}

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    @PrimaryKey
    private int Id;

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    private String Author;

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    private String Text;
}
