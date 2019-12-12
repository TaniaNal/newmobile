package com.example.firebaseauth.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.firebaseauth.api.ApiService;
import com.example.firebaseauth.utils.ApplicationEx;
import com.example.firebaseauth.entities.Panel;
import com.example.firebaseauth.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddPanelActivity extends AppCompatActivity {

    private final String PHOTO_URL = "https://m.media-amazon.com/images/M/MV5BMGU2NzRmZjUtOGUxYS00ZjdjLWEwZWItY2NlM2JhNjkxNTFmXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_UX182_CR0,0,182,268_AL_.jpg";
    private TextInputLayout panelTypeFieldLayout;
    private TextInputLayout powerFieldLayout;
    private TextInputLayout capacityFieldLayout;
    private TextInputLayout addressFieldLayout;
    private TextInputEditText panelTypeField;
    private TextInputEditText powerField;
    private TextInputEditText capacityField;
    private TextInputEditText addressField;
    private Button addBtn;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_panel);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        initViews();

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onPressAddBtn();
            }
        });
    }

    private void onPressAddBtn() {
        String model = Objects.requireNonNull(panelTypeField.getText()).toString().trim();
        String power = Objects.requireNonNull(powerField.getText()).toString().trim();
        String capacity = Objects.requireNonNull(capacityField.getText()).toString().trim();
        String address = Objects.requireNonNull(addressField.getText()).toString().trim();
        if (isDataValid(model, power, capacity, address)){
            Panel panel = new Panel(model, power, capacity, address, PHOTO_URL);
            addPanel(panel);
        }
    }

    private void addPanel(Panel panel){
        final ApiService apiService = getApplicationEx().getApiService();
        Call<Panel> call = apiService.createPanel(panel);
        progressBar.setVisibility(View.VISIBLE);
        call.enqueue(new Callback<Panel>() {
            @Override
            public void onResponse(Call<Panel> call, Response<Panel> response) {
                progressBar.setVisibility(View.INVISIBLE);
                startActivity(new Intent(AddPanelActivity.this, MainActivity.class));
            }

            @Override
            public void onFailure(Call<Panel> call, Throwable t) {
                progressBar.setVisibility(View.INVISIBLE);
                startActivity(new Intent(AddPanelActivity.this, MainActivity.class));
            }
        });
    }

    private void initViews() {
        panelTypeFieldLayout = findViewById(R.id.add_panel_layout_panel_type);
        powerFieldLayout = findViewById(R.id.add_panel_layout_power);
        capacityFieldLayout = findViewById(R.id.add_panel_layout_capacity);
        addressFieldLayout = findViewById(R.id.add_panel_layout_address);
        panelTypeField = findViewById(R.id.add_panel_activity_panel_type);
        powerField = findViewById(R.id.add_panel_activity_power);
        capacityField = findViewById(R.id.add_panel_activity_capacity);
        addressField = findViewById(R.id.add_panel_activity_address);
        addBtn = findViewById(R.id.add_panel_activity_addBtn);
        progressBar = findViewById(R.id.progress_bar);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(AddPanelActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private ApplicationEx getApplicationEx(){
        return ((ApplicationEx) Objects.requireNonNull(this.getApplication()));
    }

    private boolean isDataValid(String model, String power, String capacity, String address){
        boolean modelValid = isFieldValid(model, panelTypeFieldLayout);
        boolean powerValid = isFieldValid(power, powerFieldLayout);
        boolean capacityValid = isFieldValid(capacity, capacityFieldLayout);
        boolean addressValid = isFieldValid(address, addressFieldLayout);

        return modelValid && powerValid && capacityValid && addressValid;
    }

    private boolean isFieldValid(String field, TextInputLayout fieldLayout){
        if (field.isEmpty()){
            fieldLayout.setError(getString(R.string.required));
            fieldLayout.requestFocus();
            return false;
        } else {
            fieldLayout.setError(null);
            return true;
        }
    }
}