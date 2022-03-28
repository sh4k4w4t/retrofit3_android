package com.shakawat21.retrofit.post.fakejson_2.request;

public class Model_request_job_1 {
    private String company;
    private String department;
    private String position;
    private String phone_numbers;

    public Model_request_job_1() {
    }

    public Model_request_job_1(String company, String department, String position, String phone_numbers) {
        this.company = company;
        this.department = department;
        this.position = position;
        this.phone_numbers = phone_numbers;
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

    public String getPhone_numbers() {
        return phone_numbers;
    }

    public void setPhone_numbers(String phone_numbers) {
        this.phone_numbers = phone_numbers;
    }
}

