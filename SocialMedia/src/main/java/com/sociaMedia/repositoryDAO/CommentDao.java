package com.sociaMedia.repositoryDAO;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sociaMedia.entity.Comment;

// The @Repository annotation is used to mark the class as a Spring repository
@Repository
public class CommentDao {

	// use the Session and SessionFactory classes from Hibernate to interact with
	// the database. The @Autowired annotation is used to inject the SessionFactory
	// into the DAO class
	@Autowired
	private SessionFactory sessionFactory;

	private static final Logger LOGGER = Logger.getLogger(CommentDao.class.getName());

	// Save comment
	public void save(Comment comment) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.persist(comment);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error saving comment: " + e.getMessage());
			throw new RuntimeException("Error saving comment: " + e.getMessage());
		}
	}

	// code includes a try-catch block to handle exceptions that may occur during
	// database operations, logs the error message along with the stack trace, and
	// re-throws a custom exception as a RuntimeException with a custom error
	// message
	public Comment getById(Long id) {
		try {
			Session session = sessionFactory.getCurrentSession();
			return session.get(Comment.class, id);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error getting comment: " + e.getMessage());
			throw new RuntimeException("Error getting comment: " + e.getMessage());
		}
	}

	public List<Comment> getAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM Comment", Comment.class).getResultList();
	}

	// Update comment
	public void update(Comment comment) {
		Session session = sessionFactory.getCurrentSession();
		session.merge(comment);
	}

	// Delete comment
	// @Transactional annotation is used to ensure that database transactions are
	// managed correctly
	@Transactional
	public void delete(Comment comment) {
		Session session = sessionFactory.getCurrentSession();
		session.remove(comment);
	}

}
