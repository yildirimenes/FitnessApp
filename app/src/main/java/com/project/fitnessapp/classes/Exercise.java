package com.project.fitnessapp.classes;

import java.io.Serializable;

public class Exercise implements Serializable {
    private int exercise_id;
    private String exercise_name;
    private String exercise_image;
    private String exercise_info;
    private BodySection bodySection;

    public Exercise() {
    }

    public Exercise(int exercise_id, String exercise_name, String exercise_image, String exercise_info, BodySection bodySection) {
        this.exercise_id = exercise_id;
        this.exercise_name = exercise_name;
        this.exercise_image = exercise_image;
        this.exercise_info = exercise_info;
        this.bodySection = bodySection;
    }

    public int getExercise_id() {
        return exercise_id;
    }

    public void setExercise_id(int exercise_id) {
        this.exercise_id = exercise_id;
    }

    public String getExercise_name() {
        return exercise_name;
    }

    public void setExercise_name(String exercise_name) {
        this.exercise_name = exercise_name;
    }

    public String getExercise_image() {
        return exercise_image;
    }

    public void setExercise_image(String exercise_image) {
        this.exercise_image = exercise_image;
    }

    public String getExercise_info() {
        return exercise_info;
    }

    public void setExercise_info(String exercise_info) {
        this.exercise_info = exercise_info;
    }

    public BodySection getBodySection() {
        return bodySection;
    }

    public void setBodySection(BodySection bodySection) {
        this.bodySection = bodySection;
    }
}
