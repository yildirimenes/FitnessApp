package com.project.fitnessapp.data;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.project.fitnessapp.classes.BodySection;

import java.util.ArrayList;

public class BodySectionDao {


    public ArrayList<BodySection> allBodySection(Database db) {
        ArrayList<BodySection> bodySectionArrayList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();

        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM bodysection",null);

        while (c.moveToNext()) {
            BodySection b = new BodySection(c.getInt(c.getColumnIndexOrThrow("bodysection_id"))
                            ,c.getString(c.getColumnIndexOrThrow("bodysection_name"))
                            ,c.getString(c.getColumnIndexOrThrow("bodysection_image_name")));

            bodySectionArrayList.add(b);

        }
        return bodySectionArrayList;
    }

}
