package com.project.fitnessapp.workout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.fitnessapp.R;

import java.util.ArrayList;

public class WorkoutFragment extends Fragment{

    private RecyclerView recyclerView;
    private ArrayList<BodySection> bodySectionArrayList;
    private BodySectionAdapter bodySectionAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View design = inflater.inflate(R.layout.fragment_workout, container, false);

        recyclerView = design.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));


        BodySection bodySection1 = new BodySection(1,"Arm Workout","arm_workout");
        BodySection bodySection2 = new BodySection(2,"Abs Workout","abs_workout");
        BodySection bodySection3 = new BodySection(3,"Chest Workout","chest_workout");
        BodySection bodySection4 = new BodySection(4,"Leg Workout","leg_workout");
        BodySection bodySection5 = new BodySection(5,"Cardio Workout","cardio_workout");

        bodySectionArrayList = new ArrayList<>();

        bodySectionArrayList.add(bodySection1);
        bodySectionArrayList.add(bodySection2);
        bodySectionArrayList.add(bodySection3);
        bodySectionArrayList.add(bodySection4);
        bodySectionArrayList.add(bodySection5);



        bodySectionAdapter = new BodySectionAdapter(requireContext(),bodySectionArrayList);
        recyclerView.setAdapter(bodySectionAdapter);









        return design;


    }


}