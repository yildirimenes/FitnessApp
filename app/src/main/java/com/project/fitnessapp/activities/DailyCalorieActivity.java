package com.project.fitnessapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.webkit.WebView;

import com.project.fitnessapp.R;

public class DailyCalorieActivity extends AppCompatActivity {

    private Toolbar toolbarCalorie;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_calorie);

        toolbarCalorie = findViewById(R.id.toolbarCalorie);
        webView = findViewById(R.id.webView);

        toolbarCalorie.setTitle("Günlük Kalori İhtiyacı");
        setSupportActionBar(toolbarCalorie);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowCustomEnabled(true);

        webView.getSettings().setJavaScriptEnabled(true);

        webView.loadUrl("https://www.kaloricetveli.org/gunluk-kalori-alimi-hesaplayicisi");

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}