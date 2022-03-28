package com.sample.daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session session;


	@SuppressWarnings("unchecked")
	public String login(String username, String password) {

		String status = null;
		session = sessionFactory.openSession();

		Query passwords = session
				.createQuery(
						"select password from com.sample.model.User where username=:userName")
				.setParameter("userName", username);

		List<String> pwds = passwords.list();

		for (String pwd : pwds) {
			if (password.equals(pwd)) {
				status = "success";
			} else {
			}
		}
		System.out.println("");
		return status;
	}
}
