package com.example.myfirstapp;


import android.service.autofill.FieldClassification;

import com.example.myfirstapp.model.FootMatch;
import com.example.myfirstapp.model.RestMatch;

import java.util.List;

import io.reactivex.Single;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;


public interface FootballAPI {

        @Headers("X-RapidAPI-Key: f241e5f7b3mshc86eb80cda94d17p1feb21jsn2fddabc57909")
        @GET("predictions?iso_date=2018-12-01&market=classic&federation=UEFA/")
        Call<FootMatch> getListMatch();

}
