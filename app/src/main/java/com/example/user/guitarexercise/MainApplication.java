package com.example.user.guitarexercise;

import android.app.Application;

/**
 * Created by user on 23/01/2017.
 */
public class MainApplication extends Application{

        DBHandler db;

        @Override
        public void onCreate(){
            super.onCreate();
            db = new DBHandler(this);
        }
}

