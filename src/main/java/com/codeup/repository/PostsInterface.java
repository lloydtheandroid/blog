package com.codeup.repository;

import com.codeup.models.Post;

import java.util.List;

public interface PostsInterface {
    List all();
    void insert(Post post);
    Post find(long id);
    void update(Post post);
}
