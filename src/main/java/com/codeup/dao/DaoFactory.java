package com.codeup.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class DaoFactory {
    private static PostsInterface postsDao;
    private static UsersInterface usersDao;

    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static Session session = sessionFactory.openSession();

    public static PostsInterface getPostsDao() {
        if (postsDao == null) {
            postsDao = new ListPostsInterfaceDao(session);
        }
        return postsDao;
    }
}
