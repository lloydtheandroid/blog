package com.codeup.dao;

import com.codeup.models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ListUsersInterfaceDao implements UsersInterface {
    private Session session;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;



    public ListUsersInterfaceDao(Session session){

        this.session = session;
    }


    @Override
    public User findByUsername(String username) {
        return (User) session.createQuery("from User where username = :username")
                .setParameter("username", username)
                .uniqueResult();
    }

    @Override
    public void insert(User user) {
        Transaction tx = session.beginTransaction();
        session.save(user);
        tx.commit();
    }

    @Override
    public User update(long id) {
        return (User) session.createQuery("from User where id = :id")
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public User find(long id) {
        return (User) session.createQuery("from User where id = :id")
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }
}
