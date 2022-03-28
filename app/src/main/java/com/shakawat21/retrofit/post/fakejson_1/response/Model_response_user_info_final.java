package com.shakawat21.retrofit.post.fakejson_1.response;

public class Model_response_user_info_final {
    private String user_name;
    private String user_email;

    public Model_response_user_info_final() {
    }

    public Model_response_user_info_final(String user_name, String user_email) {
        this.user_name = user_name;
        this.user_email = user_email;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
}
