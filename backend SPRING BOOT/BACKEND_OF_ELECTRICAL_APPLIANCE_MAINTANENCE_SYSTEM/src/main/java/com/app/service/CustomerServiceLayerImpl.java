package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.entity.Customer;
import com.app.repository.CustomerRepositoryIF;

public class CustomerServiceLayerImpl implements CustomerServiceLayerIF {

	@Autowired
	private CustomerRepositoryIF custRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Customer getCustomerDetails(Long customerId) {
		
		return custRepo.findById(customerId).orElseThrow(() -> new RuntimeException("Invalid emp id !!!!!"));
	}

//	
}
