package aut.bme.hu.quoteapp.ui.favoriteList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import aut.bme.hu.quoteapp.QuotesApplication;
import aut.bme.hu.quoteapp.R;
import aut.bme.hu.quoteapp.model.Quote;
import aut.bme.hu.quoteapp.model.QuoteEntity;
import aut.bme.hu.quoteapp.ui.details.DetailsActivity;
import aut.bme.hu.quoteapp.ui.quoteList.QuoteListAdapter;
import aut.bme.hu.quoteapp.ui.quoteList.QuoteListPresenter;
import aut.bme.hu.quoteapp.ui.quoteList.QuoteListScreen;

public class FavoriteListActivity extends AppCompatActivity implements FavoriteListScreen {

    @Inject
    FavoriteListPresenter presenter;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    List<QuoteEntity> quotes = new ArrayList<QuoteEntity>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorite_list);

        getSupportActionBar().setHomeButtonEnabled(true);

        recyclerView = findViewById(R.id.favRecView);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new FavoriteListAdapter(quotes, new FavoriteListAdapter.FavoritesAdapterListener() {
            @Override
            public void buttonOnClick(int position) {
                presenter.deleteFromDatabase(quotes.get(position).getId());
                Toast.makeText(FavoriteListActivity.this, "Removed from favorites",
                        Toast.LENGTH_SHORT).show();
            }});

        recyclerView.setAdapter(adapter);

        QuotesApplication.injector.inject(this);
    }

    @Override
    public void onStart(){
        super.onStart();
        presenter.attachScreen(this);
        presenter.getQuotesFromDatabase();
    }

    @Override
    public void showQuotes(List<QuoteEntity> quoteList) {
        quotes.clear();
        quotes.addAll(quoteList);
        adapter.notifyDataSetChanged();
    }
}
