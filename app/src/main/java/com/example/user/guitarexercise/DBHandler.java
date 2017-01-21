package com.example.user.guitarexercise;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

/**
 * Created by user on 21/01/2017.
 */
public class DBHandler extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "exerciseDatabase";
    public static final String TABLE_NAME = "exercises";
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_TYPE = "type";
    public static final String KEY_BPM = "bpm";
    public static final String KEY_DATE = "date";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addExercise(Exercise exercise) {
        
    }

    public Exercise getExercise(int id) {

    }

    public List<Exercise> getAllExercises() {

    }

    public int getExerciseCount() {

    }

    public int updateExerise(Exercise exercise) {

    }

    public void deleteContact(Exercise exercise) {

    }

}

