package com.codeup.dao;

import com.codeup.models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ListUsersInterfaceDao implements UsersInterface {
    private Session session;


    public ListUsersInterfaceDao(Session session){

        this.session = session;
    }


    @Override
    public User findByUsername(String username) {

        return null;
    }

    @Override
    public void insert(User user) {
        Transaction tx = session.beginTransaction();
        session.save(user);
        tx.commit();
    }

    @Override
    public Integer updateUser(User user) {

        return null;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }
}

