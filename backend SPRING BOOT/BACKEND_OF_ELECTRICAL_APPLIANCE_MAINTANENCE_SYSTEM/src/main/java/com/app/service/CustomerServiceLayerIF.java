package com.app.service;

import com.app.dto.PersonDto;
import com.app.dto.PersonLoginDto;
import com.app.entity.Customer;


public interface CustomerServiceLayerIF {


	void addCustomer(PersonDto custDto);

	void updateCust(PersonDto custDto, Long id);

	Customer getCustomerDetails(Long customerId);

	void deleteCustomer(Long customerId);

	PersonDto verifyCustomer(PersonLoginDto customerLoginDto);
	
	
}
