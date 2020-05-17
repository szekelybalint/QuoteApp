package aut.bme.hu.quoteapp.ui.details;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import aut.bme.hu.quoteapp.R;

public class DetailsActivity extends AppCompatActivity {

    TextView textTv;
    TextView authorTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        getSupportActionBar().setHomeButtonEnabled(true);

        textTv = findViewById(R.id.textTv);
        authorTv = findViewById(R.id.authorTv);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            textTv.setText(extras.getString("text"));
            authorTv.setText(extras.getString("author"));
        }
    }
}
