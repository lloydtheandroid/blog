package com.codeup.dao;

public class DaoFactory {
    private static PostsInterface postsDao;

    public static PostsInterface getPostsDao() {
        if (postsDao == null) {
            postsDao = new ListPostsInterfaceDao();
        }
        return postsDao;
    }
}
