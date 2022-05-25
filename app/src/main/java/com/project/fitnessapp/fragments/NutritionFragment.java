package com.project.fitnessapp.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.project.fitnessapp.R;
import com.project.fitnessapp.activities.DailyCalorieActivity;
import com.project.fitnessapp.activities.FoodActivity;



public class NutritionFragment extends Fragment {


    private ImageView imgViewFoodList,imgViewDailyCalorie;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View design = inflater.inflate(R.layout.fragment_nutrition, container, false);

        imgViewDailyCalorie = design.findViewById(R.id.imgViewDailyCalorie);
        imgViewFoodList = design.findViewById(R.id.imgViewFoodList);


        imgViewDailyCalorie.setOnClickListener(view -> {
            Intent intent = new Intent(requireContext(),DailyCalorieActivity.class);
            startActivity(intent);
        });

        imgViewFoodList.setOnClickListener(view -> {
            Intent intent = new Intent(requireContext(),FoodActivity.class);
            startActivity(intent);
        });


        return design;
    }



}