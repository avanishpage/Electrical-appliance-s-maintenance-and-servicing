package com.app.service;

import com.app.dto.PersonDto;
import com.app.dto.PersonLoginDto;
<<<<<<< HEAD
import com.app.dto.PersonLoginOutDto;
import com.app.dto.PersonRegisterDto;
import com.app.dto.PersonUpdateDto;
=======

import com.app.dto.PersonLoginOutDto;
import com.app.dto.PersonRegisterDto;
>>>>>>> 4bcf322f1a801febac2e0c39bb339e122786b614


public interface CustomerServiceLayerIF {

	void addCustomerAndCart(PersonRegisterDto custDto);

	void updateCust(PersonUpdateDto custDto, Long id);

	PersonDto getCustomerDetails(Long customerId);

	void deleteCustomer(Long customerId);


<<<<<<< HEAD
	PersonLoginOutDto verifyCustomer(PersonLoginDto customerLoginDto);

=======
	PersonDtoWithRole verifyCustomer(PersonLoginDto customerLoginDto);
>>>>>>> 4bcf322f1a801febac2e0c39bb339e122786b614


}
