package aut.bme.hu.quoteapp.repository;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import aut.bme.hu.quoteapp.model.QuoteEntity;

@Database(entities = QuoteEntity.class, version = 1, exportSchema = false)
public abstract class QuoteDatabase extends RoomDatabase {
    public abstract DaoAccess daoAccess();
}
