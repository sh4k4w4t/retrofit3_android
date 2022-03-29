package com.shakawat21.retrofit.post.jsonplaceholderApi;

public class Model_Response_JsonPlaceHolderApi {
    private String title;
    private String body;
    private int userId;

    public Model_Response_JsonPlaceHolderApi() {
    }

    public Model_Response_JsonPlaceHolderApi(String title, String body, int userId) {
        this.title = title;
        this.body = body;
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}