package com.example.user.guitarexercise;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by user on 21/01/2017.
 */
public class DBHandler extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "exerciseDatabase";
    public static final String TABLE_EXERCISES = "exercises";
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
        String CREATE_TABLE = "CREATE TABLE" + TABLE_EXERCISES + "(" +
                KEY_ID + "INTEGER PRIMARY KEY" + KEY_NAME + " TEXT," +
                KEY_TYPE + " TEXT," + KEY_BPM + "TEXT," + KEY_DATE +
                "TEXT )";
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXERCISES);
        onCreate(db);
    }

    public void runSQL(String sql) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
    }

    public void addExercise(Exercise exercise) {
        String name = exercise.getName();
        ExerciseType type = exercise.getType();
        String bpm = exercise.bpmToString();
        Date date = exercise.getDate();

        String sql = "INSERT INTO " + TABLE_EXERCISES + "(" +
                KEY_NAME + ", " + KEY_TYPE + ", " + KEY_BPM + ", " +
                KEY_DATE + " ) VALUES ('" + name + "','" + type + "','" + bpm +
                "'," + date.toString() + ")";
        runSQL(sql);

    }

    public Exercise getExercise(int id) {
        String sql = "SELECT * FROM " + TABLE_EXERCISES + " WHERE " + KEY_ID
                + " = " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null) {
            cursor.moveToFirst();
            Exercise exercise = getExerciseFromDBCursor(cursor);
            return exercise;
        }
        return null;
    }

    public ArrayList<Exercise> getAllExercises() {
        ArrayList<Exercise> exerciseList = new ArrayList<Exercise>();

        String sql = "SELECT * FROM " + TABLE_EXERCISES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                Exercise exercise = getExerciseFromDBCursor(cursor);
                exerciseList.add(exercise);
            } while (cursor.moveToNext());
        }
        return exerciseList;
    }

//    public int getExerciseCount() {
//
//    }

    public void updateExerise(Exercise exercise) {
        int id = exercise.getId();
        String name = exercise.getName();
        ExerciseType type = exercise.getType();
        String bpm = exercise.bpmToString();
        Date date = exercise.getDate();

        String sql = "UPDATE " + TABLE_EXERCISES + " SET "
                + KEY_NAME + " = '" + name + "',"
                + KEY_TYPE + " = '" + type + "',"
                + KEY_BPM + " = '" + bpm + "',"
                + KEY_DATE + " = " + date.toString() + " WHERE " + KEY_ID + " = " + id;

        runSQL(sql);
    }

    public void deleteExercise(Exercise exercise) {
        int id = exercise.getId();

        String sql = "DELETE FROM " + TABLE_EXERCISES + " WHERE " + KEY_ID + " = " + id;
        runSQL(sql);
    }

    private Exercise getExerciseFromDBCursor(Cursor cursor) {
        int idColumnNum = cursor.getColumnIndex(KEY_ID);
        int nameColumnNum = cursor.getColumnIndex(KEY_NAME);
        int typeColumnNum = cursor.getColumnIndex(KEY_TYPE);
        int bpmColumnNum = cursor.getColumnIndex(KEY_BPM);
        int dateColumnNum = cursor.getColumnIndex(KEY_DATE);

        int id = Integer.parseInt(cursor.getString(idColumnNum));
        String name = cursor.getString(nameColumnNum);
        Exercise type = cursor.getString(typeColumnNum);
        String bpm = cursor.getString(bpmColumnNum);
        String date = cursor.getString(dateColumnNum);

        Exercise exercise = new Exercise(id, name, type);

        return exercise;
    }

}

