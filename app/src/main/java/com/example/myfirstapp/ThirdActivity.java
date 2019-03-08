package com.example.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myfirstapp.model.Competition;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;


public class ThirdActivity extends Activity {

    private Competition data;
    public TextView nomDeTeam;
    public TextView nomDeLigue;
    public TextView nomDeManager;
    public TextView nomDeStade;
    public TextView nomDeStadecapa;
    public TextView nomDeStadeloca;
    public TextView jerseyt;
    public ImageView ban;
    public ImageView iconclub;
    public ImageView stade;
    public ImageView jersey;



    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Gson gson = new Gson();
        Intent intent = getIntent();
        data = gson.fromJson(intent.getStringExtra("data"),Competition.class);

        ban = findViewById(R.id.ban);
        iconclub = findViewById(R.id.icon);
        stade = findViewById(R.id.stadium_photo);
        jersey = findViewById(R.id.jersey_photo);
        nomDeTeam = findViewById(R.id.team);
        nomDeLigue = findViewById(R.id.ligue_name);
        nomDeManager = findViewById(R.id.manager_name);
        nomDeStade = findViewById(R.id.stadium_name);
        nomDeStadecapa = findViewById(R.id.stadium_capacity);
        nomDeStadeloca = findViewById(R.id.stadium_location);
        jerseyt = findViewById(R.id.jersey);

        String name = data.getStrAlternate();
        final String compet = data.getStrLeague();
        final String manager = data.getStrManager();
        final int capa = data.getIntStadiumCapacity();
        String capas = Integer.toString(capa);
        final String loca = data.getStrStadiumLocation();
        final String stadium = data.getStrStadium();

        if(name == ""){
            name = data.getStrTeam();
        }

        if(stadium == null){
            capas = "";
        }


        //System.out.println("TTTTEEEESSSTTTT" + name);
        nomDeTeam.setText(name);
        nomDeLigue.setText(compet);
        nomDeStadeloca.setText(loca);
        nomDeStadecapa.setText(capas);
        nomDeStade.setText(stadium);
        nomDeManager.setText(manager);

        //holder.txtHeader.setOnClickListener(new OnClickListener() {



        Picasso
                .get()
                .load(data.getStrTeamBadge())
                .placeholder(R.drawable.ic_launcher_background)
                .resize(0,180)
                .into(iconclub);

        if(data.getStrStadiumThumb() != null) {
            Picasso
                    .get()
                    .load(data.getStrTeamBanner())
                    .placeholder(R.drawable.ic_launcher_background)
                    .resize(0, 180)
                    .into(ban);
        }


        if(data.getStrStadiumThumb() != null){


            Picasso
                    .get()
                    .load(data.getStrStadiumThumb())
                    .placeholder(R.drawable.ic_launcher_background)
                    .resize(0, 400)
                    .into(stade);
        }
        else {
            nomDeStadeloca.setText("");
        }

        if(data.getStrTeamJersey() != null){


            Picasso
                    .get()
                    .load(data.getStrTeamJersey())
                    .placeholder(R.drawable.ic_launcher_background)
                    .resize(0, 300)
                    .into(jersey);

        }

        else {
            jerseyt.setText("");
        }

    }




}
