package com.sample.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.services.LoginService;

@RestController
public class LoginController {

	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/authicate", method = RequestMethod.POST, headers = "Accept=application/x-www-form-urlencoded")
	public String login(@RequestParam(value = "username") String uname,
			@RequestParam(value = "password") String pwd) {

		System.out.println(uname);
		System.out.println(pwd);

		String status = loginService.login(uname, pwd);

		System.out.println(status);	
		return status;
	}

}
