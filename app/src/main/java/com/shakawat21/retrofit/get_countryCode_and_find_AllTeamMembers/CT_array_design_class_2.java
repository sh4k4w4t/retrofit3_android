package com.shakawat21.retrofit.get_countryCode_and_find_AllTeamMembers;

import java.util.List;

public class CT_array_design_class_2 {
    private List<CT_model_player> data;

    public CT_array_design_class_2() {
    }

    public CT_array_design_class_2(List<CT_model_player> data) {
        this.data = data;
    }

    public List<CT_model_player> getData() {
        return data;
    }

    public void setData(List<CT_model_player> data) {
        this.data = data;
    }
}
