package com.app.service;

import com.app.dto.PersonDto;
import com.app.dto.PersonDtoWithRole;
import com.app.dto.PersonLoginDto;
<<<<<<< HEAD
import com.app.dto.PersonLoginOutDto;
import com.app.dto.PersonRegisterDto;
=======
>>>>>>> be0318a17ed474e4dc2afb065a80b597bae881f7

public interface CustomerServiceLayerIF {

	void addCustomerAndCart(PersonRegisterDto custDto);

	void updateCust(PersonDto custDto, Long id);

	PersonDto getCustomerDetails(Long customerId);

	void deleteCustomer(Long customerId);

<<<<<<< HEAD
	PersonLoginOutDto verifyCustomer(PersonLoginDto customerLoginDto);
=======
	PersonDtoWithRole verifyCustomer(PersonLoginDto customerLoginDto);
>>>>>>> be0318a17ed474e4dc2afb065a80b597bae881f7

}
