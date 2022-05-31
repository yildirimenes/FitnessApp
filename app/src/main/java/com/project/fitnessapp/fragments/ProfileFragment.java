package com.project.fitnessapp.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.project.fitnessapp.R;

import java.util.Locale;


public class ProfileFragment extends Fragment {

    private TextView textViewBmi,textViewRateUs,textViewChangeLang;
    private Switch switcher;
    boolean nightMode;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View design =  inflater.inflate(R.layout.fragment_profile, container, false);

        textViewBmi = design.findViewById(R.id.textViewBmi);
        textViewRateUs = design.findViewById(R.id.textViewRateUs);
        textViewChangeLang = design.findViewById(R.id.textViewChangeLang);
        switcher = design.findViewById(R.id.switcher);

        sharedPreferences = requireContext().getSharedPreferences("MODE",Context.MODE_PRIVATE);
        nightMode = sharedPreferences.getBoolean("night",false);

        if (nightMode) {
            switcher.setChecked(true);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }


        switcher.setOnClickListener(view -> {
            if (nightMode) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                editor = sharedPreferences.edit();
                editor.putBoolean("night",false);
            }
            else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                editor = sharedPreferences.edit();
                editor.putBoolean("night",true);
            }
            editor.apply();
        });

        textViewBmi.setOnClickListener(view -> {
            Uri webpage = Uri.parse("https://www.calculator.net/bmi-calculator.html");
            Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
            startActivity(webIntent);
        });

        textViewRateUs.setOnClickListener(view -> startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("market://details?id=" + "com.android.chrome"))));

        textViewChangeLang.setOnClickListener(view -> showChangeLanguageDialog());


        return design;

    }

    private void showChangeLanguageDialog() {
        final String[] listItems = {"English","Turkish"};
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Choose Language...");
        builder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i==0) {
                    setLocale("en");
                    getActivity().recreate();

                }
                else if (i==1) {
                    setLocale("tr");
                    getActivity().recreate();
                }
                dialogInterface.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();


    }

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getActivity().getBaseContext().getResources().updateConfiguration(config,getActivity().getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = this.getActivity().getSharedPreferences("Settings",Context.MODE_PRIVATE).edit();
        editor.putString("My_Lang",lang);
        editor.apply();
    }
}