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

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Customer;
import com.app.repository.CustomerRepositoryIF;

import com.app.service.CustomerServiceLayerIF;
import com.app.service.CustomerServiceLayerImpl;

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
	

	// @PostMapping
	// public void createCustomer(@RequestBody ) {
	
	//to get all details of customer
	
//    @GetMapping("/{customerId}")
//    public ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId) {
//        Optional<Customer> optionalCustomer = CustomerServiceLayerImpl.findById(customerId);
//        if (optionalCustomer.isPresent()) {
//            Customer customer = optionalCustomer.get();
//            return ResponseEntity.ok(customer);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
    
    @GetMapping("/{customerId}") // path var or URI template var
	public Customer getEmpDetails(@PathVariable Long customerId) {
		System.out.println("in get customer " + customerId);
		return serviceLayer.getCustomerDetails(customerId);
	}
    
    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable Long customerId) {
    	serviceLayer.deleteCustomer(customerId);
    }


}
