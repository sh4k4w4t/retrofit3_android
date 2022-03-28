package com.shakawat21.retrofit.post.fakejson_2.response;

public class Model_response_job_2 {
    private String company;
    private String department;
    //phone number
    private String position;

    public Model_response_job_2() {
    }

    public Model_response_job_2(String company, String department, String position) {
        this.company = company;
        this.department = department;
        this.position = position;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
