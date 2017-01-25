package com.example.user.guitarexercise;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

/**
 * Created by user on 23/01/2017.
 */
public class AddExerciseActivity extends AppCompatActivity {

    EditText nameBox;
    EditText typeBox;
//    EditText bpmBox;
    Button addPlayerButton;
    Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstancestate) {
        super.onCreate(savedInstancestate);
        setContentView(R.layout.activity_add_exercise);
        final DBHandler db = ((MainApplication) getApplication()).db;

        nameBox = (EditText) findViewById(R.id.new_name);
        typeBox = (EditText) findViewById(R.id.new_type);
//        bpmBox = (EditText)findViewById(R.id.new_bpm);
        addPlayerButton = (Button) findViewById(R.id.add_player_button);
        cancelButton = (Button) findViewById(R.id.cancel_button);

        addPlayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameBox.getText().toString();
                String type = typeBox.getText().toString();
//            int bpm = Integer.parseInt(bpmBox.getText().toString());

                Exercise newExercise = new Exercise(name, type);
                db.addExercise(newExercise);
                backToMainActivity();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToMainActivity();
            }
        });
    }

        public void backToMainActivity() {
            Intent intent = new Intent(AddExerciseActivity.this, MainActivity.class);
            startActivity(intent);
        }

    }

