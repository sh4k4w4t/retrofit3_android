package com.shakawat21.retrofit.post.fakejson_2.response;

public class Model_response_final_4 {
    private Model_response_contacts_3 contacts;
    private String first_name;
    private Model_response_job_2 job;
    private String last_name;
    private Model_response_location_1 location;

    public Model_response_final_4() {
    }

    public Model_response_final_4(Model_response_contacts_3 contacts, String first_name, Model_response_job_2 job, String last_name, Model_response_location_1 location) {
        this.contacts = contacts;
        this.first_name = first_name;
        this.job = job;
        this.last_name = last_name;
        this.location = location;
    }

    public Model_response_contacts_3 getContacts() {
        return contacts;
    }

    public void setContacts(Model_response_contacts_3 contacts) {
        this.contacts = contacts;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public Model_response_job_2 getJob() {
        return job;
    }

    public void setJob(Model_response_job_2 job) {
        this.job = job;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Model_response_location_1 getLocation() {
        return location;
    }

    public void setLocation(Model_response_location_1 location) {
        this.location = location;
    }
}
