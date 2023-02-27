package com.sociaMedia.repositoryDAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sociaMedia.entity.Post;

@Repository
public class PostDao {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    // Save post
    public void save(Post post) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(post);
    }
    
    public Post getById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Post.class, id);
    }
    
    public List<Post> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Post", Post.class).getResultList();
    }
    
    // Update post
    public void update(Post post) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(post);
    }
    
    // Delete post
    @Transactional
    public void delete(Post post) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(post);
    }
    
}
