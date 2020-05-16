package aut.bme.hu.quoteapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import aut.bme.hu.quoteapp.model.Quote;
import aut.bme.hu.quoteapp.ui.details.DetailsActivity;
import aut.bme.hu.quoteapp.ui.quoteList.QuoteListAdapter;
import aut.bme.hu.quoteapp.ui.quoteList.QuoteListPresenter;
import aut.bme.hu.quoteapp.ui.quoteList.QuoteListScreen;

public class MainActivity extends AppCompatActivity implements QuoteListScreen {

    @Inject
    QuoteListPresenter presenter;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    List<Quote> quotes = new ArrayList<Quote>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recView);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new QuoteListAdapter(quotes, new QuoteListAdapter.AdapterListener() {
            @Override
            public void buttonOnClick(int position) {
                presenter.addFavorite(position);
            }

            @Override
            public void quoteOnClick(String text, String author) {
                // activity start with text and author
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("text", text);
                intent.putExtra("author", author);
                startActivity(intent);
                int vmi = 10;
            }
        });
        recyclerView.setAdapter(adapter);

        QuotesApplication.injector.inject(this);
    }

    @Override
    public void onStart(){
        super.onStart();
        presenter.attachScreen(this);
        try {
            presenter.getQuotesFromInteractor();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showQuotes(List<Quote> quoteList) {
        quotes.clear();
        quotes.addAll(quoteList);
        adapter.notifyDataSetChanged();
    }

    public void favoriteClicked(View view){
        int recId = recyclerView.findViewById(view.getId()).getId();
        int viewId = view.getId();
        int valami = 10;
    }
}
