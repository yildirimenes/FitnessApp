package com.project.fitnessapp.classes;

import java.io.Serializable;

public class Food implements Serializable {
    private int food_id;
    private String food_name;
    private String food_amount;
    private int food_calorie;

    public Food() {
    }

    public Food(int food_id, String food_name, String food_amount, int food_calorie) {
        this.food_id = food_id;
        this.food_name = food_name;
        this.food_amount = food_amount;
        this.food_calorie = food_calorie;
    }

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getFood_amount() {
        return food_amount;
    }

    public void setFood_amount(String food_amount) {
        this.food_amount = food_amount;
    }

    public int getFood_calorie() {
        return food_calorie;
    }

    public void setFood_calorie(int food_calorie) {
        this.food_calorie = food_calorie;
    }
}
