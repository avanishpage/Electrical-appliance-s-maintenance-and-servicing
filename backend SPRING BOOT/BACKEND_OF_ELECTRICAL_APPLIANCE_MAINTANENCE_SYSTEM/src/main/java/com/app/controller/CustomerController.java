package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.CustomerServiceLayerIF;

@RestController
public class CustomerController {

	@Autowired
	private CustomerServiceLayerIF serviceLayer;

	// @PostMapping
	// public void createCustomer(@RequestBody ) {

}
