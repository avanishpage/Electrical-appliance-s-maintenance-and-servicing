package com.app.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.CustomerDto;
import com.app.entity.Customer;
import com.app.exceptions.CustomerNotFoundException;
import com.app.repository.CustomerRepositoryIF;

@Service
@Transactional
public class CustomerServiceLayerImpl implements CustomerServiceLayerIF {
	@Autowired 
	private CustomerRepositoryIF custRepo;
	@Autowired
	private ModelMapper mapper;

	@Override
	public void addCustomer(CustomerDto custDto) {
		//System.out.println(custDto);
		
		Customer customerEntity=new Customer();
				mapper.map(custDto, customerEntity);
		
		custRepo.save(customerEntity);
		
		
		
		
	}

	@Override
	public void updateCust(CustomerDto custDto, Long id) {
		System.out.println(id);
	
		Customer customerEntity=custRepo.findById(id).orElseThrow(()->  new CustomerNotFoundException("customer by id "+id+" not present"));
		mapper.map(custDto, customerEntity);
		
	}
	

}
