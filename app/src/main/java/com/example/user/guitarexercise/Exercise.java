package com.example.user.guitarexercise;

import java.util.Date;
import java.util.UUID;

/**
 * Created by user on 21/01/2017.
 */
public class Exercise {

    private int id;
    private String name;
    private String type;
    private int bpm;
    private Date date;


    public Exercise(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.bpm = 0;
        this.date = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBpm() {
        return bpm;
    }

    public void setBpm(int bpm) {
        this.bpm = bpm;
    }

    //   @Override
    public String bpmToString() {
        return getBpm() + "bpm";
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
