package com.shakawat21.retrofit.get_by_id;

import com.shakawat21.retrofit.get_all.ObjectDataClass;

import java.util.List;

public class OurMainDataClass_by_ID {

    private ObjectDataClass_for_ID data;

    public OurMainDataClass_by_ID() {
    }

    public OurMainDataClass_by_ID(ObjectDataClass_for_ID data) {
        this.data = data;
    }

    public ObjectDataClass_for_ID getData() {
        return data;
    }

    public void setData(ObjectDataClass_for_ID data) {
        this.data = data;
    }
}
