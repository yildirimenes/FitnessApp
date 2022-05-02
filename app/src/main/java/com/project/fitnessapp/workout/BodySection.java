package com.project.fitnessapp.workout;

public class BodySection {
    private int bodysection_id;
    private String bodysection_name;
    private String bodysection_image_name;

    public BodySection() {
    }

    public BodySection(int bodysection_id, String bodysection_name, String bodysection_image_name) {
        this.bodysection_id = bodysection_id;
        this.bodysection_name = bodysection_name;
        this.bodysection_image_name = bodysection_image_name;
    }

    public int getBodysection_id() {
        return bodysection_id;
    }

    public void setBodysection_id(int bodysection_id) {
        this.bodysection_id = bodysection_id;
    }

    public String getBodysection_name() {
        return bodysection_name;
    }

    public void setBodysection_name(String bodysection_name) {
        this.bodysection_name = bodysection_name;
    }

    public String getBodysection_image_name() {
        return bodysection_image_name;
    }

    public void setBodysection_image_name(String bodysection_image_name) {
        this.bodysection_image_name = bodysection_image_name;
    }
}
