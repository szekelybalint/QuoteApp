package aut.bme.hu.quoteapp.ui.favoriteList;

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
import aut.bme.hu.quoteapp.model.QuoteEntity;

public class FavoriteListAdapter extends RecyclerView.Adapter<FavoriteListAdapter.QuoteViewHolder> {
    private List<QuoteEntity> quotes;
    public static FavoritesAdapterListener onClickListener;


    public FavoriteListAdapter(List<QuoteEntity> quoteList, FavoritesAdapterListener listener){
        quotes = quoteList;
        onClickListener = listener;
    }

    @NonNull
    @Override
    public FavoriteListAdapter.QuoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.favorite_list_row, parent, false);
        FavoriteListAdapter.QuoteViewHolder vh = new FavoriteListAdapter.QuoteViewHolder(row);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteListAdapter.QuoteViewHolder holder, final int position) {
        QuoteEntity q = quotes.get(position);
        holder.quoteAuthorTv.setText(q.getAuthor());
        holder.quoteTextTv.setText(q.getText());
    }

    @Override
    public int getItemCount() {
        return quotes.size();
    }

    public static class QuoteViewHolder extends  RecyclerView.ViewHolder{

        public TextView quoteTextTv;
        public TextView quoteAuthorTv;
        public Button deleteButton;

        public QuoteViewHolder(View row){
            super(row);
            this.quoteTextTv = row.findViewById(R.id.favoriteListRowTextTv);
            this.quoteAuthorTv = row.findViewById(R.id.favoriteListRowAuthorTv);
            this.deleteButton = row.findViewById(R.id.bDeleteFav);

            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    onClickListener.buttonOnClick(getAdapterPosition());
                }
            });
        }
    }

    public interface FavoritesAdapterListener {
        void buttonOnClick(int position);
    }
}
