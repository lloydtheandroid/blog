package com.codeup.dao;

import com.codeup.models.Post;

import java.util.List;

public class ListPostsDao implements PostDao {
    private List<Post> posts;
    @Override
    public List<Post> all() {
        if (posts == null) {
            posts = generatePosts();
        }
        return posts;
    }

    @Override
    public Long insert(Post post) {
        if (posts == null) {
            posts = generatePosts();
        }
        post.setId((long) posts.size());
        posts.add(new Post());
        return posts;
    }
}
