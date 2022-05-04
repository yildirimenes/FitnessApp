package com.project.fitnessapp.classes;

import java.io.Serializable;

public class Exercise implements Serializable {
    private int exercise_id;
    private String exercise_name;
    private BodySection bodySection;

    public Exercise() {
    }

    public Exercise(int exercise_id, String exercise_name, BodySection bodySection) {
        this.exercise_id = exercise_id;
        this.exercise_name = exercise_name;
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

    public BodySection getBodySection() {
        return bodySection;
    }

    public void setBodySection(BodySection bodySection) {
        this.bodySection = bodySection;
    }
}
