package aut.bme.hu.quoteapp.ui.quoteList;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import aut.bme.hu.quoteapp.R;
import aut.bme.hu.quoteapp.model.Quote;

public class QuoteListAdapter extends RecyclerView.Adapter<QuoteListAdapter.QuoteViewHolder> {
    private List<Quote> quotes;
    public static AdapterListener onClickListener;

    public QuoteListAdapter(List<Quote> quoteList, AdapterListener listener){
        quotes = quoteList;
        onClickListener = listener;
    }

    @NonNull
    @Override
    public QuoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.quote_list_row, parent, false);
        QuoteViewHolder vh = new QuoteViewHolder(row);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull QuoteViewHolder holder, final int position) {
        Quote q = quotes.get(position);
        holder.quoteAuthorTv.setText(q.getAuthor());
        holder.quoteTextTv.setText(q.getQuoteText());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // DB: add to favorites at quotes(position)
                int number = position;
            }
        });
    }

    @Override
    public int getItemCount() {
        return quotes.size();
    }

    public static class QuoteViewHolder extends  RecyclerView.ViewHolder{

        public TextView quoteTextTv;
        public TextView quoteAuthorTv;
        public Button favoriteButton;

        public QuoteViewHolder(View row){
            super(row);
            this.quoteTextTv = row.findViewById(R.id.quoteListRowTextTv);
            this.quoteAuthorTv = row.findViewById(R.id.quoteListRowAuthorTv);
            this.favoriteButton = row.findViewById(R.id.bFav);

            quoteTextTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.quoteOnClick(quoteTextTv.getText().toString(), quoteAuthorTv.getText().toString());
                }
            });

            favoriteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    onClickListener.buttonOnClick(getAdapterPosition());
                }
            });
        }
    }

    public interface AdapterListener {
        void buttonOnClick(int position);
        void quoteOnClick(String text, String author);
    }
}
