package com.example.hemanth.transitionanimation.model;

/**
 * Created by hemanth on 13/10/16.
 */

public class Model {

    private String name;
    private String place;
    private String number;

    public Model(String name, String place, String number) {
        this.name = name;
        this.place = place;
        this.number = number;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }



}
