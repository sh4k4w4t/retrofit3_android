package com.shakawat21.retrofit.post.fakejson_2.response;

public class Model_response_location_1 {
    private String city;
    private String country;
    private String state;
    private String street;

    public Model_response_location_1() {
    }

    public Model_response_location_1(String city, String country, String state, String street) {
        this.city = city;
        this.country = country;
        this.state = state;
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
