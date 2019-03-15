package com.example.myfirstapp.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.view.View;

import com.example.myfirstapp.R;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void randomMe (View view) {

        // Create an Intent to start the second activity
        Intent randomIntent = new Intent(this, SecondActivity.class);

        startActivity(randomIntent);
    }
}
