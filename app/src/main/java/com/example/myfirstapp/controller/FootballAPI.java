package com.example.myfirstapp.controller;


import com.example.myfirstapp.model.ListCompetition;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;


public interface FootballAPI {
        @GET("search_all_teams.php")
        Call<ListCompetition> getListMatch (@Query("s") String sport, @Query("c") String country );

}
