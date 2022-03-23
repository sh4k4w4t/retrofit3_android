package com.shakawat21.retrofit.get_countryCode_and_find_AllTeamMembers;

public class CT_model_player {

    private String fullname;
    private String dateofbirth;
    private String gender;
    private CT_model_position country_team_model_position;

    public CT_model_player() {
    }

    public CT_model_player(String fullname, String dateofbirth, String gender, CT_model_position country_team_model_position) {
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

    public CT_model_position getCountry_team_model_position() {
        return country_team_model_position;
    }

    public void setCountry_team_model_position(CT_model_position country_team_model_position) {
        this.country_team_model_position = country_team_model_position;
    }
}
