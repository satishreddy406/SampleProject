package com.sample.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.model.User;
import com.sample.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user", method = RequestMethod.POST, headers = "Accept=application/json")
	public void newUser(@RequestBody(required = true) String user) {
		User user1 = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			user1 = mapper.readValue(user, User.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		userService.addUser(user1);

		System.out.println(user1);
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<User> getUser(@RequestParam(value = "uname") String username) {
		return userService.getUser(username);
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<User> getAllUsers() {
		System.out.println("allUSers");

		return userService.getAllUsers();
	}

	@RequestMapping(value = "/user", method = RequestMethod.PUT, headers = "Accept=application/json")
	public List<User> updateUser(@RequestBody(required = true) String user) {

		User user1 = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			user1 = mapper.readValue(user, User.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(user1);	

		
		return userService.updateUser(user1);

	}

}
