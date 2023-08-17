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
import com.app.dto.CustomerDto;
import com.app.entity.Customer;
import com.app.service.CustomerServiceLayerIF;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerServiceLayerIF serviceLayer;


	@PostMapping("/add")
	public ApiResponse createCustomer(@RequestBody @Valid CustomerDto custDto) {
		
		serviceLayer.addCustomer(custDto);
		return new ApiResponse(LocalDateTime.now(), "customer successfully created!");
		
	}
	
	@PutMapping("/update/{customerId}")
	public ApiResponse updateCustomer(@RequestBody CustomerDto custDto,@PathVariable Long customerId) {
		
		serviceLayer.updateCust(custDto,customerId);
		return new ApiResponse(LocalDateTime.now(), "customer information successfully updated!");
		
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
    
    @DeleteMapping("/delete/{customerId}")
    public ApiResponse deleteCustomer(@PathVariable Long customerId) {
    	serviceLayer.deleteCustomer(customerId);
    	return new ApiResponse(LocalDateTime.now(), "customer successfully deleted!");
    }


}
