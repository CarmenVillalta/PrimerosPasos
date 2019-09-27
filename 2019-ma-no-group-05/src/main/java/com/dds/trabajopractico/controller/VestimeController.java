package com.dds.trabajopractico.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VestimeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public String getAllCustomers() {
 
//		List<Customer> listOfCustomers = customerService.getAllCustomers();
//		model.addAttribute("customer", new Customer());
//		model.addAttribute("listOfCustomers", listOfCustomers);
		return "test";
	}

}
