package com.codeup.models;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Post {

    @NotNull
    private long id;

    @NotNull
    @Size(min=2, max=100)
    private String title;

    @NotNull
    @Size(min = 2, max = 1000)
    private String body;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

}
