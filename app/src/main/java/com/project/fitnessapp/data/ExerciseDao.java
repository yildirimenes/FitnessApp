package com.project.fitnessapp.data;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.project.fitnessapp.classes.BodySection;
import com.project.fitnessapp.classes.Exercise;

import java.util.ArrayList;

public class ExerciseDao {


    public ArrayList<Exercise> allExerciseByBodySectionId(Database db,int bodysection_id) {
        ArrayList<Exercise> exerciseArrayList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();

        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM bodysection,exerciselist WHERE exerciselist.bodysection_id = bodysection.bodysection_id AND exerciselist.bodysection_id ="+ bodysection_id,null);

        while (c.moveToNext()) {

            BodySection b = new BodySection(c.getInt(c.getColumnIndexOrThrow("bodysection_id"))
                    ,c.getString(c.getColumnIndexOrThrow("bodysection_name"))
                    ,c.getString(c.getColumnIndexOrThrow("bodysection_image_name")));

            Exercise  e = new Exercise(c.getInt(c.getColumnIndexOrThrow("exercise_id"))
                    ,c.getString(c.getColumnIndexOrThrow("exercise_name")),b);

            exerciseArrayList.add(e);

        }
        return exerciseArrayList;

    }

    /*
    public ArrayList<Exercise> exerciseSearch(Database db,String searchWords) {

        ArrayList<Exercise> exerciseArrayList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();

        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM exerciselist WHERE exercise_name like '%\"+searchWords+\"%'",null);

        while (c.moveToNext()) {
            Exercise  e = new Exercise(c.getInt(c.getColumnIndexOrThrow("exercise_id"))
                    ,c.getString(c.getColumnIndexOrThrow("exercise_name")),null);

            exerciseArrayList.add(e);
        }
        return exerciseArrayList;
    }
    */




}
