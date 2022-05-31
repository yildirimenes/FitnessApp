package com.project.fitnessapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.project.fitnessapp.R;
import com.project.fitnessapp.adapters.FoodAdapter;
import com.project.fitnessapp.classes.Food;
import com.project.fitnessapp.data.Database;
import com.project.fitnessapp.data.FoodDao;

import java.util.ArrayList;

public class FoodActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    private Toolbar toolbarFood;
    private RecyclerView recFood;
    public ArrayList<Food> foodArrayList;
    private FoodAdapter adapter;
    private Database db;
    private FloatingActionButton btn_floating;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        toolbarFood = findViewById(R.id.toolbarFood);
        recFood = findViewById(R.id.recFood);
        btn_floating = findViewById(R.id.btn_floating);

        db = new Database(this);

        toolbarFood.setTitle(R.string.HowManyCalories);
        setSupportActionBar(toolbarFood);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowCustomEnabled(true);

        recFood.setHasFixedSize(true);
        recFood.setLayoutManager(new LinearLayoutManager(this));

        foodArrayList = new FoodDao().allFood(db);

        adapter = new FoodAdapter(this,foodArrayList,db);
        recFood.setAdapter(adapter);


        recFood.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                if (newState > 0) {
                    btn_floating.hide();
                }
                else {
                    btn_floating.show();
                }
                super.onScrollStateChanged(recyclerView, newState);
            }
        });

        btn_floating.setOnClickListener(view -> {
            Intent intent = new Intent(FoodActivity.this, TotalCalorieActivity.class);
            startActivity(intent);
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar_food_menu,menu);

        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(this);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.e("onQueryTextSubmit",query);
        foodArrayList = new FoodDao().foodSearch(db,query);
        adapter = new FoodAdapter(this,foodArrayList,db);
        recFood.setAdapter(adapter);

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.e("onQueryTextChange",newText);
        foodArrayList = new FoodDao().foodSearch(db,newText);
        adapter = new FoodAdapter(this,foodArrayList,db);
        recFood.setAdapter(adapter);

        return false;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
