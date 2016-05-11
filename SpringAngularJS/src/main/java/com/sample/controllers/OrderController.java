package com.sample.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.sample.model.Customer;
import com.sample.services.CustomerService;
import com.sample.services.OrderService;

@RestController
public class OrderController {
	private static final Logger log = Logger.getLogger("OrderController.class");

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/saveOrder", method = RequestMethod.POST)
	public String getAllCustomers(@RequestBody(required = true) String order) {

		log.info("Order Dtetails ==>" + order);
		Gson gson = new Gson();
		
		String response = "";
/*		response = orderService.saveOrder(order);*/
		orderService.save(order);
		return response;

	}

}
