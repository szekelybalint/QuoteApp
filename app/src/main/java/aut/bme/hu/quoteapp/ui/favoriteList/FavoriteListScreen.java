package aut.bme.hu.quoteapp.ui.favoriteList;

import java.util.List;

import aut.bme.hu.quoteapp.model.QuoteEntity;

public interface FavoriteListScreen {
    void showQuotes(List<QuoteEntity> quoteList);
}
