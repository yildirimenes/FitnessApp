package com.project.fitnessapp.data;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.project.fitnessapp.classes.Food;

import java.util.ArrayList;

public class FoodDao {
    public ArrayList<Food> allFood(Database db) {
        ArrayList<Food> foodArrayList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();

        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM foodlist",null);

        while (c.moveToNext()) {
            Food f = new Food(c.getInt(c.getColumnIndexOrThrow("food_id"))
                    ,c.getString(c.getColumnIndexOrThrow("food_name"))
                    ,c.getString(c.getColumnIndexOrThrow("food_amount"))
                    ,c.getInt(c.getColumnIndexOrThrow("food_calorie")));

            foodArrayList.add(f);
        }
        return foodArrayList;
    }

    public ArrayList<Food> foodSearch(Database db,String searchWords) {
        ArrayList<Food> foodArrayList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();

        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM foodlist WHERE food_name like '%"+searchWords+"%'",null);

        while (c.moveToNext()) {
            Food f = new Food(c.getInt(c.getColumnIndexOrThrow("food_id"))
                    ,c.getString(c.getColumnIndexOrThrow("food_name"))
                    ,c.getString(c.getColumnIndexOrThrow("food_amount"))
                    ,c.getInt(c.getColumnIndexOrThrow("food_calorie")));

            foodArrayList.add(f);
        }
        db.close();
        return foodArrayList;
    }
}
