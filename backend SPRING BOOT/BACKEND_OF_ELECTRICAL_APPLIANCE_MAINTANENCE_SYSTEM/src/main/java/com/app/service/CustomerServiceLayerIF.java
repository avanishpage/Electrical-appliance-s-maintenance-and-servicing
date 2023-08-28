package com.app.service;

import com.app.dto.PersonDto;
import com.app.dto.PersonLoginDto;
import com.app.dto.PersonLoginOutDto;
import com.app.dto.PersonRegisterDto;
import com.app.dto.PersonUpdateDto;


public interface CustomerServiceLayerIF {

	void addCustomerAndCart(PersonRegisterDto custDto);

	void updateCust(PersonUpdateDto custDto, Long id);

	PersonDto getCustomerDetails(Long customerId);

	void deleteCustomer(Long customerId);


	PersonLoginOutDto verifyCustomer(PersonLoginDto customerLoginDto);



}
