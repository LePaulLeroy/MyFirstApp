package com.example.myfirstapp.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.myfirstapp.view.SecondActivity;
import com.example.myfirstapp.model.Competition;
import com.example.myfirstapp.model.ListCompetition;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
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
    private SharedPreferences share;
    private Gson gson;



    private FootballAPI restApi;

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
         gson = new GsonBuilder()
                .setLenient()
                .create();



      //  OkHttpClient.Builder httpClient = new OkHttpClient.Builder().addHeader(HeadersContract.HEADER_AUTHONRIZATION, O_AUTH_AUTHENTICATION);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.thesportsdb.com/api/v1/json/1/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

       restApi = retrofit.create(FootballAPI.class);

        //On crée un objet retrofit


        //On crée notre instance de notre RestAPI Pokemon.

        share = SecondActivity.getContext().getSharedPreferences("cache", Context.MODE_PRIVATE);


        cachefunct(false);

        }



    public ListCompetition getCompet(){
        return  listcompet;
    }




    public void cachefunct (boolean cache){

        if (share.contains("club") & cache ){
            String listclub = share.getString("club", "");
            Type listType = new TypeToken<ArrayList<Competition>>(){}.getType();
            List<Competition>  compet = gson.fromJson(listclub,listType);
            listcompet = new ListCompetition();
            listcompet.setTeams(compet);
            view.showTab(compet);
        }

        else {
            Call<ListCompetition> call = restApi.getListMatch("Soccer", "Spain");
            call.enqueue(new Callback<ListCompetition>() {
                @Override
                public void onResponse(Call<ListCompetition> call, Response<ListCompetition> response) {
                    listcompet = response.body();
                    //System.out.println("IIICCCCCCIIII CEST LE LOSC" + response);
                    List<Competition>  compet = listcompet.getCompetitions();
                    view.showTab(compet);
                    share.edit()
                            .putString("club",gson.toJson(compet))
                            .apply();

                }

                @Override
                public void onFailure(Call<ListCompetition> call, Throwable t) {
                    Log.d("ERROR", "Api Error");
                }
            });

        }
    }
}

