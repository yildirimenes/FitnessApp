package com.project.fitnessapp.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.project.fitnessapp.R;
import com.project.fitnessapp.adapters.FoodAdapter;
import com.project.fitnessapp.classes.Food;
import com.project.fitnessapp.data.Database;
import com.project.fitnessapp.data.DatabaseCopyHelper;
import com.project.fitnessapp.data.FoodDao;

import java.io.IOException;
import java.util.ArrayList;


public class NutritionFragment extends Fragment implements SearchView.OnQueryTextListener {

    Toolbar toolbarFood;
    RecyclerView recFood;
    private ArrayList <Food> foodArrayList;
    private FoodAdapter foodAdapter;
    private Database db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View design = inflater.inflate(R.layout.fragment_nutrition, container, false);

        toolbarFood = design.findViewById(R.id.toolbarFood);

        recFood = design.findViewById(R.id.recFood);
        recFood.setHasFixedSize(true);
        recFood.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));

        //copyDatabase();

        db = new Database(requireContext());

        toolbarFood.setTitle("Kaç Kalori ?");
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbarFood);


        foodArrayList = new FoodDao().allFood(db);

        foodAdapter = new FoodAdapter(requireContext(),foodArrayList);
        recFood.setAdapter(foodAdapter);


        return design;
    }


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar_food_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}