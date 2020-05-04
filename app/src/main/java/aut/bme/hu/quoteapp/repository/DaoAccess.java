package aut.bme.hu.quoteapp.repository;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import aut.bme.hu.quoteapp.model.QuoteEntity;

@Dao
public interface DaoAccess {
    @Insert
    void insertQuote(QuoteEntity quote);

    @Query("SELECT * FROM QuoteEntity")
    List<QuoteEntity> getAllQuotes();

    @Delete
    void deleteQuote(QuoteEntity quote);
}
