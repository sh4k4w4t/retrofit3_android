package com.shakawat21.retrofit.get_countryCode_and_find_AllTeamMembers;

public class Country_team_model_player {

    private String fullname;
    private String dateofbirth;
    private String gender;
    private Country_team_model_position country_team_model_position;

    public Country_team_model_player() {
    }

    public Country_team_model_player(String fullname, String dateofbirth, String gender, Country_team_model_position country_team_model_position) {
        this.fullname = fullname;
        this.dateofbirth = dateofbirth;
        this.gender = gender;
        this.country_team_model_position = country_team_model_position;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Country_team_model_position getCountry_team_model_position() {
        return country_team_model_position;
    }

    public void setCountry_team_model_position(Country_team_model_position country_team_model_position) {
        this.country_team_model_position = country_team_model_position;
    }
}
