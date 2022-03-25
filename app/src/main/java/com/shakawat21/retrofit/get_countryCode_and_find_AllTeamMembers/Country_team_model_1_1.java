package com.shakawat21.retrofit.get_countryCode_and_find_AllTeamMembers;

public class Country_team_model_1_1 {
    private int id;
    private String name;
    private int country_id;

    public Country_team_model_1_1() {
    }

    public Country_team_model_1_1(int id, String name, int country_id) {
        this.id = id;
        this.name = name;
        this.country_id = country_id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCountry_id() {
        return country_id;
    }
}
