package com.hib.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.hib.model.User;
/*
 Updating a Row/Employee
Session.update() and session.merge() are both used for updating the rows of data in the database.

Session.update(): If you are sure that the session does not contain an already persistent instance with the same identifier, use update to save the data in hibernate.
Session.merge():  If you want to save your modifications at any time without knowing about the state of a session, use merge() in hibernate.
 */

public class UpdatingUser {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
		         User u = new User();
	              u.setId(3);
			    u.setEmail("mhaseeb@perscholas");
			    u.setFullname("M haseeb");
			    u.setPassword("123456");
			    session.merge(u);
			    session.getTransaction().commit();
			    session.close();
		}
}
