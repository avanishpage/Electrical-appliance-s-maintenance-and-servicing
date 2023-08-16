package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.repository.CustomerRepositoryIF;

public class CustomerServiceLayerImpl implements CustomerServiceLayerIF {
	@Autowired 
	private CustomerRepositoryIF custRepo;
	

}
