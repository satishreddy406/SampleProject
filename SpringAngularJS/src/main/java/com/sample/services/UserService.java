package com.sample.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.daos.UserDao;
import com.sample.model.User;

@Service("UserService")
public class UserService {

	@Autowired
	private UserDao userDao;

	public void addUser(User user) {
		userDao.addUser(user);
	}

	public List<User> getUser(String username) {
		// TODO Auto-generated method stub
		return userDao.getUser(username);
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userDao.getAllUsers();
	}

	public List<User> updateUser(User user1) {
		return userDao.updateUser(user1);
	}
}
