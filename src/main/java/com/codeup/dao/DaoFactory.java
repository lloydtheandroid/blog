package com.codeup.dao;

import com.codeup.models.Post;

public class DaoFactory {
    private static Post postsDao;

    public static Post getPostsDao() {
        if (postsDao == null) {
            postsDao = new ListPostsDao();
        }
        return postsDao;
    }
}
