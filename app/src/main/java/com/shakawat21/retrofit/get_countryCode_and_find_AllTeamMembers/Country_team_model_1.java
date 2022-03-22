package com.shakawat21.retrofit.get_countryCode_and_find_AllTeamMembers;

public class Country_team_model_1 {
    private int id;
    private int country_id;

    public Country_team_model_1() {
    }

    public Country_team_model_1(int id, int country_id) {
        this.id = id;
        this.country_id = country_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }
}
