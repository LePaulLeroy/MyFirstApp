package com.example.myfirstapp.controller;

import android.util.Log;

import com.example.myfirstapp.FootballAPI;
import com.example.myfirstapp.SecondActivity;
import com.example.myfirstapp.model.Competition;
import com.example.myfirstapp.model.ListCompetition;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Vincent ETIENNE on 13/02/2019.
 */
public class MainController {

    private ListCompetition listcompet;
    private SecondActivity view;

    public MainController(SecondActivity secondActivity) {
        this.view = secondActivity;
    }

    public void onCreate() {


        //Pour ceux qui veulent aller plus loin
        //Il faut créer ces objets avec des singletons.
        // Voir le cours de Génie Logiciel -> Singleton
        //Pour ceux qui veulent encore aller plus loin
        //Voir Injection de dépendances
        //On crée un objet gson
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();


      //  OkHttpClient.Builder httpClient = new OkHttpClient.Builder().addHeader(HeadersContract.HEADER_AUTHONRIZATION, O_AUTH_AUTHENTICATION);


        //On crée un objet retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.thesportsdb.com/api/v1/json/1/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        //On crée notre instance de notre RestAPI Pokemon.
        FootballAPI restApi = retrofit.create(FootballAPI.class);


        Call<ListCompetition> call = restApi.getListMatch("Soccer", "Spain");
        call.enqueue(new Callback<ListCompetition>() {
            @Override
            public void onResponse(Call<ListCompetition> call, Response<ListCompetition> response) {
                listcompet = response.body();
                //System.out.println("IIICCCCCCIIII CEST LE LOSC" + response);
               List<Competition>  compet = listcompet.getCompetitions();
                view.showTab(compet);
            }

            @Override
            public void onFailure(Call<ListCompetition> call, Throwable t) {
                Log.d("ERROR", "Api Error");
            }
        });

    }

    public ListCompetition getCompet(){
        return  listcompet;
    }
}
