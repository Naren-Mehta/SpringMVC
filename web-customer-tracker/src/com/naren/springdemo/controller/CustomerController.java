package com.naren.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.naren.springdemo.dao.CustomerDAO;
import com.naren.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listCustomer(Model model) {
		
		List<Customer> customerList= customerDAO.getCustomers();
		model.addAttribute("customers", customerList);
		return "list-customers";
	}
	

}
