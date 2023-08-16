package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import com.app.dto.CustomerDto;
=======
import com.app.entity.Customer;
>>>>>>> 8270ddc198c6b7b7d322befb097b46558d2ae5b6
import com.app.repository.CustomerRepositoryIF;


public interface CustomerServiceLayerIF {

<<<<<<< HEAD
	void addCustomer(CustomerDto custDto);

	void updateCust(CustomerDto custDto, Long id);
=======
	Customer getCustomerDetails(Long customerId);
>>>>>>> 8270ddc198c6b7b7d322befb097b46558d2ae5b6

	
	
}
