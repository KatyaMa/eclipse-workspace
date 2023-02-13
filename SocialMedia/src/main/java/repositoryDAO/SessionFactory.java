package repositoryDAO;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import entity.*;
import jakarta.transaction.Transaction;

public class SessionFactory {

	// create a new instance of SessionFactory
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	// create a new instance of Session
	Session session = sessionFactory.openSession();

	// begin a new transaction
	Transaction tx = session.beginTransaction();

	// create a new instance of Photo
	Photo photo = new Photo();
	photo.setTitle("My Photo");
	photo.setDescription("This is a photo of me");

	// insert the record into the database
	session.save(photo);

	// commit the transaction
	tx.commit();

	// close the session
	session.close();

	// close the session factory
	sessionFactory.close();
}
