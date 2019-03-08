package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.myfirstapp.controller.MainController;
import com.example.myfirstapp.model.Competition;
import com.example.myfirstapp.model.ListCompetition;
import com.google.gson.Gson;

import java.util.List;


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

    public void showTab(List<Competition> listCompet) {
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // define an adapter
        mAdapter = new MyAdapter(listCompet,new ListenerClickCompet());
        recyclerView.setAdapter(mAdapter);
    }

    public class ListenerClickCompet implements View.OnClickListener {

        @Override
        public void onClick (View v){
            Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
            int index = recyclerView.getChildLayoutPosition(v);
            Gson gson = new Gson();
            intent.putExtra("data",gson.toJson(controller.getCompet().getCompetitions().get(index)));
            startActivity(intent);
        }
    }
}




