package com.project.fitnessapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.project.fitnessapp.R;

public class TotalCalorieActivity extends AppCompatActivity {

    Toolbar toolbarTotalCalorie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_calorie);

        toolbarTotalCalorie = findViewById(R.id.toolbarTotalCalorie);
        toolbarTotalCalorie.setTitle(R.string.CalorieCalculation);

        setSupportActionBar(toolbarTotalCalorie);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}