package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Customer;
import com.app.repository.CustomerRepositoryIF;

@Service
@Transactional
public interface CustomerServiceLayerIF {

	Customer getCustomerDetails(Long customerId);

	
	
}
