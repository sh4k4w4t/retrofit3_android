package com.shakawat21.retrofit.get_countryCode_and_find_AllTeamMembers;

import java.util.List;

public class Country_team_array_design_class_2 {
    private List<Country_team_model_player> data;

    public Country_team_array_design_class_2() {
    }

    public Country_team_array_design_class_2(List<Country_team_model_player> data) {
        this.data = data;
    }

    public List<Country_team_model_player> getData() {
        return data;
    }

    public void setData(List<Country_team_model_player> data) {
        this.data = data;
    }
}
