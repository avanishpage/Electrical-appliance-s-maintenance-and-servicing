package com.app.service;

import com.app.dto.PersonDto;
import com.app.dto.PersonDtoWithRole;
import com.app.dto.PersonLoginDto;

public interface CustomerServiceLayerIF {

	void addCustomerAndCart(PersonDto custDto);

	void updateCust(PersonDto custDto, Long id);

	PersonDto getCustomerDetails(Long customerId);

	void deleteCustomer(Long customerId);

	PersonDtoWithRole verifyCustomer(PersonLoginDto customerLoginDto);

}
