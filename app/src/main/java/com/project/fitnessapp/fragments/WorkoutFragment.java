package com.project.fitnessapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.fitnessapp.R;
import com.project.fitnessapp.classes.BodySection;
import com.project.fitnessapp.adapters.BodySectionAdapter;
import com.project.fitnessapp.data.BodySectionDao;
import com.project.fitnessapp.data.Database;
import com.project.fitnessapp.data.DatabaseCopyHelper;

import java.io.IOException;
import java.util.ArrayList;

public class WorkoutFragment extends Fragment{

    private RecyclerView recWorkout;
    private ArrayList<BodySection> bodySectionArrayList;
    private BodySectionAdapter bodySectionAdapter;
    private Database db;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View design = inflater.inflate(R.layout.fragment_workout, container, false);

        recWorkout = design.findViewById(R.id.recWorkout);
        recWorkout.setHasFixedSize(true);
        recWorkout.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));

        copyDatabase();

        db = new Database(requireContext());

        bodySectionArrayList = new BodySectionDao().allBodySection(db);

        bodySectionAdapter = new BodySectionAdapter(requireContext(),bodySectionArrayList);
        recWorkout.setAdapter(bodySectionAdapter);


        return design;
    }


    public void copyDatabase() {

        DatabaseCopyHelper helper = new DatabaseCopyHelper(requireContext());

        try {
            helper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        helper.openDataBase();

    }



}