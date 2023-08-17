package com.app.service;

import com.app.dto.CustomerLoginDto;
import com.app.dto.PersonDto;
import com.app.entity.Customer;


public interface CustomerServiceLayerIF {


	void addCustomer(PersonDto custDto);

	void updateCust(PersonDto custDto, Long id);

	Customer getCustomerDetails(Long customerId);

	void deleteCustomer(Long customerId);

	PersonDto verifyCustomer(CustomerLoginDto customerLoginDto);
	
	
}
