package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.app.dto.CustomerDto;
import com.app.dto.CustomerLoginDto;
import com.app.entity.Customer;

import com.app.repository.CustomerRepositoryIF;


public interface CustomerServiceLayerIF {


	void addCustomer(CustomerDto custDto);

	void updateCust(CustomerDto custDto, Long id);

	Customer getCustomerDetails(Long customerId);

	void deleteCustomer(Long customerId);

	CustomerDto verifyCustomer(CustomerLoginDto customerLoginDto);
	
	
}
