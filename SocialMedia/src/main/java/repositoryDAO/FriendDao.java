package repositoryDAO;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entity.Friend;

@Repository
public class FriendDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private static final Logger LOGGER = Logger.getLogger(FriendDao.class.getName());
	
	
	// CRUD operations for the Friend entity, along with error handling to log and re-throw any exceptions that might occur during database operations
	public void save(Friend friend) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.persist(friend);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error saving friend: " + e.getMessage());
			throw new RuntimeException("Error saving friend: " + e.getMessage());
		}
	}
	
	public Friend getById(Long id) {
		try {
			Session session = sessionFactory.getCurrentSession();
			return session.get(Friend.class, id);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error getting friend: " + e.getMessage());
			throw new RuntimeException("Error getting friend: " + e.getMessage());
		}
	}
	
	public List<Friend> getAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM Friend", Friend.class).getResultList();
	}
	
	// Update friend
	public void update(Friend friend) {
		Session session = sessionFactory.getCurrentSession();
		session.merge(friend);
	}
	
	// Delete friend
	@Transactional
	public void delete(Friend friend) {
		Session session = sessionFactory.getCurrentSession();
		session.remove(friend);
	}

}

