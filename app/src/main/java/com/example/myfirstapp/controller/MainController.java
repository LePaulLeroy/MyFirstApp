package com.example.myfirstapp.controller;

import android.util.Log;

import com.example.myfirstapp.FootballAPI;
import com.example.myfirstapp.SecondActivity;
import com.example.myfirstapp.model.DetailMatch;
import com.example.myfirstapp.model.FootMatch;
import com.example.myfirstapp.model.RestMatch;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Vincent ETIENNE on 13/02/2019.
 */
public class MainController {

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
                .baseUrl("https://football-prediction-api.p.rapidapi.com/api/v2/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        //On crée notre instance de notre RestAPI Pokemon.
        FootballAPI restApi = retrofit.create(FootballAPI.class);


        Call<FootMatch> call = restApi.getListMatch();
        call.enqueue(new Callback<FootMatch>() {
            @Override
            public void onResponse(Call<FootMatch> call, Response<FootMatch> response) {
                FootMatch DetailMatch = response.body();
                System.out.println("IIICCCCCCIIII CEST LE LOSC" + response);
                com.example.myfirstapp.model.DetailMatch[] listMatch = DetailMatch.getData();
                view.showTab(listMatch);
            }

            @Override
            public void onFailure(Call<FootMatch> call, Throwable t) {
                Log.d("ERROR", "Api Error");
            }
        });

    }
}
