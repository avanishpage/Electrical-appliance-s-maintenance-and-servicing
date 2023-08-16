package com.app.controller;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CustomerDto;
import com.app.service.CustomerServiceLayerIF;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerServiceLayerIF serviceLayer;

	@PostMapping("/add")
	public void createCustomer(@RequestBody @Valid CustomerDto custDto) {
		
		serviceLayer.addCustomer(custDto);
		
	}
	
	@PutMapping("/update/{id}")
	public void updateCustomer(@RequestBody CustomerDto custDto,@PathVariable Long id) {
		
		serviceLayer.updateCust(custDto,id);
		
	}
	
}
