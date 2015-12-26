package com.sample.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.daos.LoginDao;

@Service("loginService")
public class LoginService {

	@Autowired
	LoginDao loginDao;

	public String login(String uname, String pwd) {
		return loginDao.login(uname, pwd);
	}
}
