package repositoryDAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entity.User;

@Repository
public class UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	// Save user
	public void save(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(user);  // use persist() instead save()
	}

	public User getById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(User.class, id);
	}

	public List<User> getAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM User", User.class).getResultList();
	}

	// Update user
	public void update(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.merge(user);  // use the merge() method to update an entity in the database
	}

	// Delete user
	// @Transactional annotation on the deleteUser() method ensures that the method is executed within a transaction, which is required when making changes to the database
	@Transactional
	public void deleteUser(User user) {
	    Session session = sessionFactory.getCurrentSession();     // use of sessionFactory.getCurrentSession() to obtain a Session object is recommended for Spring-managed Hibernate sessions
	    session.remove(user);
	}
	
	

}