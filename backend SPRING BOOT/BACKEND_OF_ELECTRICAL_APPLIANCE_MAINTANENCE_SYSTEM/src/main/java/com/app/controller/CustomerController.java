package com.app.controller;

import java.time.LocalDateTime;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.PersonDto;
import com.app.dto.PersonLoginDto;
import com.app.entity.Customer;
import com.app.service.CustomerServiceLayerIF;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerServiceLayerIF serviceLayer;

	// post method for adding a new customer entry
	@PostMapping("/add")
	public ApiResponse createCustomer(@RequestBody @Valid PersonDto custDto) {

		serviceLayer.addCustomer(custDto);
		return new ApiResponse(LocalDateTime.now(), "customer successfully created!");

	}

	// put method for updating existing customer's details
	@PutMapping("/update/{customerId}")
	public ApiResponse updateCustomer(@RequestBody PersonDto custDto, @PathVariable Long customerId) {

		serviceLayer.updateCust(custDto, customerId);
		return new ApiResponse(LocalDateTime.now(), "customer information successfully updated!");

	}

	// get method to get customer details
	@GetMapping("/{customerId}") // path var or URI template var
	public Customer getEmpDetails(@PathVariable Long customerId) {
		System.out.println("in get customer " + customerId);
		return serviceLayer.getCustomerDetails(customerId);
	}

	// delete method to delete a customer permanantly
	@DeleteMapping("/delete/{customerId}")
	public ApiResponse deleteCustomer(@PathVariable Long customerId) {
		serviceLayer.deleteCustomer(customerId);
		return new ApiResponse(LocalDateTime.now(), "customer successfully deleted!");
	}

	// customer login
	@PostMapping("/login")
	public PersonDto loginCustomer(@RequestBody PersonLoginDto customerLoginDto) {

		return serviceLayer.verifyCustomer(customerLoginDto);
	}

}
