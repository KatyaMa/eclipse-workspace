package repositoryDAO;

import java.time.LocalDateTime;
import java.util.List;

import entity.Message;
import entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

// This DAO class has methods for adding a new message, getting a message by ID, getting all messages, getting messages between two users, deleting a message, and closing the EntityManager and EntityManagerFactory when they are no longer needed
public class MessageDao {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public MessageDao() {
		entityManagerFactory = Persistence.createEntityManagerFactory("persistence-unit-name");
		entityManager = entityManagerFactory.createEntityManager();
	}

	public void addMessage(Message message) {
		message.setCreatedAt(LocalDateTime.now());
		entityManager.getTransaction().begin();
		entityManager.persist(message);
		entityManager.getTransaction().commit();
	}

	public Message getMessageById(Long id) {
		return entityManager.find(Message.class, id);
	}

	public List<Message> getAllMessages() {
		TypedQuery<Message> query = entityManager.createQuery("SELECT m FROM Message m", Message.class);
		return query.getResultList();
	}

	public List<Message> getMessagesBySenderAndReceiver(User sender, User receiver) {
		TypedQuery<Message> query = entityManager.createQuery(
				"SELECT m FROM Message m WHERE m.sender = :sender AND m.receiver = :receiver", Message.class);
		query.setParameter("sender", sender);
		query.setParameter("receiver", receiver);
		return query.getResultList();
	}

	public void deleteMessage(Long id) {
		entityManager.getTransaction().begin();
		Message message = entityManager.find(Message.class, id);
		entityManager.remove(message);
		entityManager.getTransaction().commit();
	}

	public void close() {
		entityManager.close();
		entityManagerFactory.close();
	}
}
