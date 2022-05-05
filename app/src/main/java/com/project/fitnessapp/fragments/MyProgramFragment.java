package com.project.fitnessapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

import com.project.fitnessapp.R;

public class MyProgramFragment extends Fragment {

    private CalendarView calendarView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View design =  inflater.inflate(R.layout.fragment_my_program, container, false);

        calendarView = design.findViewById(R.id.calendarView);
        return design;
    }
}