package com.codeup.dao;

import com.codeup.models.Post;

import java.util.List;

public interface PostDao {
    List<Post> all();

    Long insert(Post post);
}
