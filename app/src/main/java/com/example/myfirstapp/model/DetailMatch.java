package com.example.myfirstapp.model;

import java.util.Date;

public class DetailMatch {

    private int id;
    private String federation;
    private Odds[] odds;
    private float field_length;
    private String away_team;
    private String competition_name;
    private Date start_date;
    private String prediction;
    private String market;
    private float home_strength;
    private Probabilities [] probabilities;
    private int stadium_capacity;
    private Boolean is_expired;
    private int distance_between_teams;
    private Date last_update_at;
    private String competition_cluster;
    private String pending;
    private String result;
    private float away_strength;
    private float field_width;
    private String home_team;
    private int season;

    public int getId() {
        return id;
    }

    public String getFederation() {
        return federation;
    }

    public Odds[] getOdds() {
        return odds;
    }

    public float getField_length() {
        return field_length;
    }

    public String getAway_team() {
        return away_team;
    }

    public String getCompetition_name() {
        return competition_name;
    }

    public Date getStart_date() {
        return start_date;
    }

    public String getPrediction() {
        return prediction;
    }

    public String getMarket() {
        return market;
    }

    public float getHome_strength() {
        return home_strength;
    }

    public Probabilities[] getProbabilities() {
        return probabilities;
    }

    public int getStadium_capacity() {
        return stadium_capacity;
    }

    public Boolean getIs_expired() {
        return is_expired;
    }

    public int getDistance_between_teams() {
        return distance_between_teams;
    }

    public Date getLast_update_at() {
        return last_update_at;
    }

    public String getCompetition_cluster() {
        return competition_cluster;
    }

    public String getPending() {
        return pending;
    }

    public String getResult() {
        return result;
    }

    public float getAway_strength() {
        return away_strength;
    }

    public float getField_width() {
        return field_width;
    }

    public String getHome_team() {
        return home_team;
    }

    public int getSeason() {
        return season;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFederation(String federation) {
        this.federation = federation;
    }

    public void setOdds(Odds[] odds) {
        this.odds = odds;
    }

    public void setField_length(float field_length) {
        this.field_length = field_length;
    }

    public void setAway_team(String away_team) {
        this.away_team = away_team;
    }

    public void setCompetition_name(String competition_name) {
        this.competition_name = competition_name;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public void setPrediction(String prediction) {
        this.prediction = prediction;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public void setHome_strength(float home_strength) {
        this.home_strength = home_strength;
    }

    public void setProbabilities(Probabilities[] probabilities) {
        this.probabilities = probabilities;
    }

    public void setStadium_capacity(int stadium_capacity) {
        this.stadium_capacity = stadium_capacity;
    }

    public void setIs_expired(Boolean is_expired) {
        this.is_expired = is_expired;
    }

    public void setDistance_between_teams(int distance_between_teams) {
        this.distance_between_teams = distance_between_teams;
    }

    public void setLast_update_at(Date last_update_at) {
        this.last_update_at = last_update_at;
    }

    public void setCompetition_cluster(String competition_cluster) {
        this.competition_cluster = competition_cluster;
    }

    public void setPending(String pending) {
        this.pending = pending;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setAway_strength(float away_strength) {
        this.away_strength = away_strength;
    }

    public void setField_width(float field_width) {
        this.field_width = field_width;
    }

    public void setHome_team(String home_team) {
        this.home_team = home_team;
    }

    public void setSeason(int season) {
        this.season = season;
    }
}
