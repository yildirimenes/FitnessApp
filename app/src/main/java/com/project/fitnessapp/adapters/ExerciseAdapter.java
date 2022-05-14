package com.project.fitnessapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.project.fitnessapp.R;
import com.project.fitnessapp.activities.DetailActivity;
import com.project.fitnessapp.classes.Exercise;
import com.project.fitnessapp.data.Database;

import java.util.List;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.CardViewDesignObjectHandler>{
    private Context mContext;
    private List <Exercise> exerciseList;
    private Database db;


    public ExerciseAdapter(Context mContext, List<Exercise> exerciseList, Database db) {
        this.mContext = mContext;
        this.exerciseList = exerciseList;
        this.db = db;
    }


    public class CardViewDesignObjectHandler extends RecyclerView.ViewHolder {
        public TextView textViewExercise;
        public CardView cardViewExercise;
        public ImageView imageViewNextActivity;


        public CardViewDesignObjectHandler(@NonNull View itemView) {
            super(itemView);
            textViewExercise = itemView.findViewById(R.id.textViewExercise);
            cardViewExercise = itemView.findViewById(R.id.cardViewExercise);
            imageViewNextActivity = itemView.findViewById(R.id.imageViewNextActivity);
        }
    }

    @NonNull
    @Override
    public CardViewDesignObjectHandler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_exercise_design,parent,false);
        return new CardViewDesignObjectHandler(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewDesignObjectHandler holder, int position) {
        final Exercise exercise = exerciseList.get(position);

        holder.textViewExercise.setText(exercise.getExercise_name());

        holder.imageViewNextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra("exercise_object",exercise);
                mContext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return exerciseList.size();
    }




}
