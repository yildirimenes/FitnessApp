package com.project.fitnessapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import android.os.Bundle;
import com.project.fitnessapp.R;
import com.project.fitnessapp.adapters.ExerciseAdapter;
import com.project.fitnessapp.classes.BodySection;
import com.project.fitnessapp.classes.Exercise;
import com.project.fitnessapp.data.Database;
import com.project.fitnessapp.data.ExerciseDao;
import java.util.ArrayList;

public class ExerciseActivity extends AppCompatActivity {
    private RecyclerView recExercise;
    private Toolbar toolbar;
    private ArrayList<Exercise> exerciseArrayList;
    private ExerciseAdapter exerciseAdapter;
    private BodySection bodySection;
    private Database db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        toolbar = findViewById(R.id.toolbar);
        recExercise = findViewById(R.id.recFoodCalorie);

        db = new Database(this);

        bodySection = (BodySection) getIntent().getSerializableExtra("bodysection_object");

        toolbar.setTitle(bodySection.getBodysection_name());
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowCustomEnabled(true);


        exerciseArrayList = new ExerciseDao().allExerciseByBodySectionId(db,bodySection.getBodysection_id());


        recExercise.setHasFixedSize(true);
        recExercise.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));


        exerciseAdapter = new ExerciseAdapter(this,exerciseArrayList, db);
        recExercise.setAdapter(exerciseAdapter);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}