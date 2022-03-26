package com.shakawat21.retrofit.workWithTwoAdapter;

public class Model_2_2 {
    private String resource;
    private int id;
    private int country_id;
    private String firstname;
    private String lastname;
    private String fullname;
    private String image_path;
    private String dateofbirth;
    private String gender;
    private String battingstyle;
    private String bowlingstyle;
    private Model_2_1 position;
    private String updated_at;

    public Model_2_2() {
    }

    public Model_2_2(String resource, int id, int country_id, String firstname, String lastname, String fullname, String image_path, String dateofbirth, String gender, String battingstyle, String bowlingstyle, Model_2_1 position, String updated_at) {
        this.resource = resource;
        this.id = id;
        this.country_id = country_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.fullname = fullname;
        this.image_path = image_path;
        this.dateofbirth = dateofbirth;
        this.gender = gender;
        this.battingstyle = battingstyle;
        this.bowlingstyle = bowlingstyle;
        this.position = position;
        this.updated_at = updated_at;
    }

    public String getResource() {
        return resource;
    }

    public int getId() {
        return id;
    }

    public int getCountry_id() {
        return country_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFullname() {
        return fullname;
    }

    public String getImage_path() {
        return image_path;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public String getGender() {
        return gender;
    }

    public String getBattingstyle() {
        return battingstyle;
    }

    public String getBowlingstyle() {
        return bowlingstyle;
    }

    public Model_2_1 getPosition() {
        return position;
    }

    public String getUpdated_at() {
        return updated_at;
    }
}
