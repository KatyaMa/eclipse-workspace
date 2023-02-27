package com.sociaMedia.repositoryDAO;

import java.util.List;

import com.sociaMedia.entity.Like;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

// This LikeDao class includes methods to add, retrieve and remove likes. It also includes methods to get all likes for a given user or post
public class LikeDao {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public LikeDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence-unit-name");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void addLike(Like like) {
        entityManager.getTransaction().begin();
        entityManager.persist(like);
        entityManager.getTransaction().commit();
    }

    public List<Like> getLikesByUserId(Long userId) {
        TypedQuery<Like> query = entityManager.createQuery("SELECT l FROM Like l WHERE l.user.id = :userId", Like.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    public List<Like> getLikesByPostId(Long postId) {
        TypedQuery<Like> query = entityManager.createQuery("SELECT l FROM Like l WHERE l.post.id = :postId", Like.class);
        query.setParameter("postId", postId);
        return query.getResultList();
    }

    public void removeLike(Like like) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.contains(like) ? like : entityManager.merge(like));
        entityManager.getTransaction().commit();
    }

    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
