package com.shakawat21.retrofit.get.get_all;

import java.util.List;

public class OurMainDataClass {

    private List<ObjectDataClass> data;

    public OurMainDataClass() {
    }

    public OurMainDataClass(List<ObjectDataClass> data) {
        this.data = data;
    }

    public List<ObjectDataClass> getData() {
        return data;
    }

    public void setData(List<ObjectDataClass> data) {
        this.data = data;
    }
}
