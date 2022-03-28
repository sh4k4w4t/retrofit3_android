package com.shakawat21.retrofit.post.fakejson_2.request;

public class Model_request_data_4 {
    private String first_name;
    private String last_name;
    private Model_request_location_3 location;
    private Model_request_contacts_2 contacts;
    private Model_request_job_1 job;

    public Model_request_data_4() {
    }

    public Model_request_data_4(String first_name, String last_name, Model_request_location_3 location, Model_request_contacts_2 contacts, Model_request_job_1 job) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.location = location;
        this.contacts = contacts;
        this.job = job;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Model_request_location_3 getLocation() {
        return location;
    }

    public void setLocation(Model_request_location_3 location) {
        this.location = location;
    }

    public Model_request_contacts_2 getContacts() {
        return contacts;
    }

    public void setContacts(Model_request_contacts_2 contacts) {
        this.contacts = contacts;
    }

    public Model_request_job_1 getJob() {
        return job;
    }

    public void setJob(Model_request_job_1 job) {
        this.job = job;
    }
}