package com.shakawat21.retrofit.get_countryCode_and_find_AllTeamMembers;

public class Country_team_model_position {
    private String name;
    private int id;

    public Country_team_model_position() {
    }

    public Country_team_model_position(String name, int id) {
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
