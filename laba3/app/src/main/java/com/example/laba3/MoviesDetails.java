package com.example.laba3;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.squareup.picasso.Picasso;
import java.util.Objects;

public class MoviesDetails extends AppCompatActivity {

    private TextView title;
    private TextView year;
    private TextView description;
    private ImageView poster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movies_details);

        getIncomingIntent();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    private void getIncomingIntent() {
        if (getIntent().hasExtra("title") &&
                getIntent().hasExtra("year") &&
                getIntent().hasExtra("description")) {
            String titleInfo = getIntent().getStringExtra("title");
            String yearInfo = getIntent().getStringExtra("year");
            String descriptionInfo = getIntent().getStringExtra("description");
            String posterInfo = getIntent().getStringExtra("poster");

            setInfo(titleInfo, yearInfo, descriptionInfo, posterInfo);
        }
    }

    private void initViews(){
        title = findViewById(R.id.panel_details_type);
        year = findViewById(R.id.panel_details_year);
        description = findViewById(R.id.panel_details_description);
        poster = findViewById(R.id.panel_details_image_view);
    }

    private void setInfo(String titleInfo, String yearInfo,
                         String descriptionInfo, String posterInfo) {
        initViews();
        title.setText(titleInfo);
        year.setText(yearInfo);
        description.setText(descriptionInfo);
        Picasso.get().load(posterInfo).into(poster);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(MoviesDetails.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}