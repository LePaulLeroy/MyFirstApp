package com.example.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.myfirstapp.controller.MainController;
import com.example.myfirstapp.model.DetailMatch;
import com.example.myfirstapp.model.FootMatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class SecondActivity extends Activity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private MainController controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        // use this setting to
        controller = new MainController(this);
        controller.onCreate();
    }

    public void showTab(DetailMatch[] listMatch) {
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // define an adapter
        mAdapter = new MyAdapter(listMatch);
        recyclerView.setAdapter(mAdapter);
    }
}




