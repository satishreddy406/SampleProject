package com.sample.controllers;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

	@RequestMapping("/SpringAngularJS")
	public String index(ModelMap map){
		return "index";
	}
}
