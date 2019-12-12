package com.example.firebaseauth.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.firebaseauth.R;
import com.squareup.picasso.Picasso;
import java.util.Objects;

public class PanelDetailsActivity extends AppCompatActivity {

    private TextView panelType;
    private TextView power;
    private TextView capacity;
    private TextView address;
    private ImageView imageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel_details);

        getIncomingIntent();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }


    private void initViews(){
        panelType = findViewById(R.id.panel_details_type);
        power = findViewById(R.id.panel_details_power);
        capacity = findViewById(R.id.panel_details_capacity);
        address = findViewById(R.id.panel_details_address);
        imageUrl = findViewById(R.id.panel_details_image_view);
    }

    private void getIncomingIntent() {
        if (getIntent().hasExtra("panel_type") &&
                getIntent().hasExtra("power") &&
                getIntent().hasExtra("capacity") &&
                getIntent().hasExtra("address")) {
            String panelTypeInfo = getIntent().getStringExtra("panel_type");
            String powerInfo = getIntent().getStringExtra("power");
            String capacityInfo = getIntent().getStringExtra("capacity");
            String addressInfo = getIntent().getStringExtra("address");
            String imageUrlInfo = getIntent().getStringExtra("image");

            setInfo(panelTypeInfo, powerInfo, capacityInfo, addressInfo, imageUrlInfo);
        }
    }

    private void setInfo(String panelTypeInfo, String powerInfo, String capacityInfo,
                         String addressInfo, String imageUrlInfo) {
        initViews();
        panelType.setText(panelTypeInfo);
        power.setText(powerInfo);
        capacity.setText(capacityInfo);
        address.setText(addressInfo);
        Picasso.get().load(imageUrlInfo).into(imageUrl);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(PanelDetailsActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}