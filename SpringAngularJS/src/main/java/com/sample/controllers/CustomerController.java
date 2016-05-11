package com.sample.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.sample.model.Customer;
import com.sample.services.CustomerService;

@RestController
public class CustomerController {

	private static final Logger log = Logger.getLogger("CustomerController.class");

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET)
	public String getAllCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		customers = customerService.getAllCustomers();
		log.info("Customers===> :" + customers);
		Gson gson = new Gson();
		return gson.toJson(customers);

	}

}
