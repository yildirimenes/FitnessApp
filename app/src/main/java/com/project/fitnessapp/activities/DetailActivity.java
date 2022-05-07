package com.project.fitnessapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.project.fitnessapp.R;
import com.project.fitnessapp.classes.Exercise;

import pl.droidsonroids.gif.GifImageView;

public class DetailActivity extends AppCompatActivity {
    private GifImageView gifImageView;
    private TextView textViewDetailName,textViewExerciseInfo;
    private Exercise exercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        gifImageView = findViewById(R.id.gifImageView);
        textViewDetailName = findViewById(R.id.textViewDetailName);
        textViewExerciseInfo = findViewById(R.id.textViewExerciseInfo);

        exercise = (Exercise) getIntent().getSerializableExtra("exercise_object");

        textViewDetailName.setText(exercise.getExercise_name());
        textViewExerciseInfo.setText(exercise.getExercise_info());

        gifImageView.setImageResource(getResources().getIdentifier(exercise.getExercise_image(),"drawable",getPackageName()));




    }
}