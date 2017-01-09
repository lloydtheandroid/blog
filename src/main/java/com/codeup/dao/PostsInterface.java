package com.codeup.dao;

import com.codeup.models.Post;
import javafx.geometry.Pos;

import java.util.List;

public interface PostsInterface {
    List all();
    void insert(Post post);
    Post find(long id);
    Post update(long id);
}
