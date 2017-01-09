package com.codeup.dao;

import com.codeup.models.Post;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class ListPostsInterfaceDao implements PostsInterface {
    private Session session;

    public ListPostsInterfaceDao(Session session){

        this.session = session;
    }

    @Override
    public List<Post> all() {

        return session.createQuery("from Post").list();
    }

    @Override
    public void insert(Post post){
        Transaction tx = session.beginTransaction();
        session.save(post);
        tx.commit();
    }
}
