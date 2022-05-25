package com.project.fitnessapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.fitnessapp.R;
import com.project.fitnessapp.classes.Food;
import com.project.fitnessapp.data.Database;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.CardViewDesignObjectHandler>{
    private Context mContext;
    private List<Food> foodList;
    private Database db;

    public FoodAdapter(Context mContext, List<Food> foodList,Database db) {
        this.mContext = mContext;
        this.foodList = foodList;
        this.db = db;
    }


    public class CardViewDesignObjectHandler extends RecyclerView.ViewHolder {

        public TextView textViewFoodName;
        public TextView textViewFoodAmount;
        public TextView textViewFoodCalorie;
        public ToggleButton toggleButton;

        public CardViewDesignObjectHandler(@NonNull View itemView) {
            super(itemView);

            textViewFoodName = itemView.findViewById(R.id.textViewFoodName);
            textViewFoodAmount = itemView.findViewById(R.id.textViewFoodAmount);
            textViewFoodCalorie = itemView.findViewById(R.id.textViewFoodCalorie);
            toggleButton = itemView.findViewById(R.id.toggleButton);
        }

    }

    @NonNull
    @Override
    public CardViewDesignObjectHandler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_food_design,parent,false);
        return new CardViewDesignObjectHandler(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewDesignObjectHandler holder, int position) {
        final Food food = foodList.get(position);

        holder.textViewFoodName.setText(food.getFood_name());
        holder.textViewFoodAmount.setText(food.getFood_amount());
        holder.textViewFoodCalorie.setText(String.valueOf(food.getFood_calorie()));

        holder.toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.toggleButton.isChecked()) {
                    Toast.makeText(mContext,"Sepete Eklendi",Toast.LENGTH_SHORT).show();

                }
                else {

                }

            }
        });



    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }


}
