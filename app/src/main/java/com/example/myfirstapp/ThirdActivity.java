package com.example.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myfirstapp.model.Competition;
import com.google.gson.Gson;



public class ThirdActivity extends Activity {

    private Competition data;


    public void onCreate (Bundle savedInstanceState){

        Gson gson = new Gson();
        Intent intent = getIntent();
        data = gson.fromJson(intent.getStringExtra("data"),Competition.class);

    }


}
