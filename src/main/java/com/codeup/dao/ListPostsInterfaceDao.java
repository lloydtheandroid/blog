package com.codeup.dao;

import com.codeup.models.Post;

import java.util.ArrayList;
import java.util.List;
import java.lang.Long;

public class ListPostsInterfaceDao implements PostsInterface {
    private List<Post> posts;

    public ListPostsInterfaceDao(){
        posts = new ArrayList<>();
    }

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
        post.setId((long) posts.size()+1);
        posts.add(post);
        return post.getId();
    }



    private ArrayList<Post> generatePosts(){
        return null;
    }
}
