package com.shakawat21.retrofit.get_countryCode_and_find_AllTeamMembers;

import com.google.gson.annotations.SerializedName;

public class Country_team_model_position_2_1 {
    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private int id;

    public Country_team_model_position_2_1() {
    }

    public Country_team_model_position_2_1(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
