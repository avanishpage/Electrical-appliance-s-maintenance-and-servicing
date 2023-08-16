package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Customer;
import com.app.repository.CustomerRepositoryIF;
import com.app.service.CustomerServiceLayerIF;
import com.app.service.CustomerServiceLayerImpl;

@RestController
public class CustomerController {

	@Autowired
	private CustomerServiceLayerIF serviceLayer;

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

}
