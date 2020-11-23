package com.example.healthnepal;

import com.google.gson.annotations.SerializedName;

public class Post {

    private int id;

    private int userId;

    private String title;

    private String body;

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
