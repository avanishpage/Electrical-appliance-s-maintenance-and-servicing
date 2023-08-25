package com.app.service;

import com.app.dto.PersonDto;
import com.app.dto.PersonLoginDto;
import com.app.entity.Person;

public interface CustomerServiceLayerIF {

	void addCustomerAndCart(PersonDto custDto);

	void updateCust(PersonDto custDto, Long id);

	PersonDto getCustomerDetails(Long customerId);

	void deleteCustomer(Long customerId);

	PersonDto verifyCustomer(PersonLoginDto customerLoginDto);

}
