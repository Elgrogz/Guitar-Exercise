package com.example.user.guitarexercise;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by user on 23/01/2017.
 */
public class MainActivity extends AppCompatActivity {

    Button viewRoutine;
    Button createRoutine;
    Button viewExercises;
    Button addExercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewRoutine = (Button) findViewById(R.id.button_view_routines);
        createRoutine = (Button) findViewById(R.id.button_create_routine);
        viewExercises = (Button) findViewById(R.id.button_view_exercises);
        addExercise = (Button) findViewById(R.id.button_add_exercise);


        final DBHandler db = ((MainApplication)getApplication()).db;


        viewRoutine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewRoutineActivity.class);
                startActivity(intent);
            }
        });

        createRoutine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateRoutineActivity.class);
                startActivity(intent);
            }
        });

        viewExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewExerciseActivity.class);
                startActivity(intent);
            }
        });

        addExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddExerciseActivity.class);
                startActivity(intent);
            }
        });




    }
}
