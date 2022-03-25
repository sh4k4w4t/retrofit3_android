package com.shakawat21.retrofit.get_countryCode_and_find_AllTeamMembers;

import com.google.gson.annotations.SerializedName;

public class Country_team_model_player_2_2 {

    @SerializedName("fullname")
    private String fullname;

    @SerializedName("dateofbirth")
    private String dateofbirth;

    @SerializedName("gender")
    private String gender;

    @SerializedName("position")
    private Country_team_model_position_2_1 position;

    public Country_team_model_player_2_2() {
    }

    public Country_team_model_player_2_2(String fullname, String dateofbirth, String gender, Country_team_model_position_2_1 position) {
        this.fullname = fullname;
        this.dateofbirth = dateofbirth;
        this.gender = gender;
        this.position = position;
    }

    public String getFullname() {
        return fullname;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public String getGender() {
        return gender;
    }

    public Country_team_model_position_2_1 getPosition() {
        return position;
    }
}
