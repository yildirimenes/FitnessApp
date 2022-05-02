package com.project.fitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.project.fitnessapp.myprogram.MyProgramFragment;
import com.project.fitnessapp.nutrition.NutritionFragment;
import com.project.fitnessapp.profile.ProfileFragment;
import com.project.fitnessapp.workout.WorkoutFragment;

public class MenuActivity extends AppCompatActivity {

    private BottomNavigationView btm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btm = findViewById(R.id.btm);

        btm.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.action_workout:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContext,new WorkoutFragment()).commit();
                        break;
                    case R.id.action_myprogram:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContext,new MyProgramFragment()).commit();
                        break;
                    case R.id.action_nutrition:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContext,new NutritionFragment()).commit();
                        break;
                    case R.id.action_profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContext,new ProfileFragment()).commit();
                        break;

                }

                return true;
            }
        });
    }
}