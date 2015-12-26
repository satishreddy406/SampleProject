package com.sample.daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sample.model.User;

@Component
public class UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	Transaction transaction = null;
	Session session = null;

	public void addUser(User user) {
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<User> getUser(String username) {
		session = sessionFactory.openSession();
		Query passwords = session.createQuery(
				"from com.sample.model.User where username=:userName")
				.setParameter("userName", username);

		List<User> users = passwords.list();

		return users;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		session = sessionFactory.openSession();
		Query query = session.createQuery("from com.sample.model.User");
		List<User> users = query.list();
		return users;
	}

	@SuppressWarnings("unchecked")
	public List<User> updateUser(User user1) {
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();

		User user = (User) session.get(User.class, user1.getId());

		session.update(user);
		user.setPassword(user1.getPassword());

		transaction.commit();
		System.out.println("Update Successfully");
		
		
		Query query = session.createQuery("from com.sample.model.User");
		List<User> users = query.list();
		session.close();

		return users;

	}
}
