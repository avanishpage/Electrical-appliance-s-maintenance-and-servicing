package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.PersonDto;
import com.app.dto.PersonLoginDto;
import com.app.dto.PersonLoginOutDto;
import com.app.dto.PersonRegisterDto;
import com.app.dto.PersonUpdateDto;
import com.app.entity.Cart;
import com.app.entity.Customer;
<<<<<<< HEAD
import com.app.enums.Role;
=======

import com.app.enums.Role;

>>>>>>> 4bcf322f1a801febac2e0c39bb339e122786b614
import com.app.exceptions.CustomerNotFoundException;
import com.app.exceptions.CustomerPasswordNotMatchingException;
import com.app.repository.CartRepository;
import com.app.repository.CustomerRepositoryIF;

@Service
@Transactional
public class CustomerServiceLayerImpl implements CustomerServiceLayerIF {

	@Autowired
	private CustomerRepositoryIF custRepo;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private CartRepository cartRepo;

	@Override
	public void addCustomerAndCart(PersonRegisterDto custDto) {
		// System.out.println(custDto);

		Customer customerEntity = new Customer();
		mapper.map(custDto, customerEntity);
		customerEntity.setRole(Role.CUSTOMER);

		Cart cart = new Cart();

		cart.addCartToCustomer(customerEntity);
		
		custRepo.save(customerEntity);
		cartRepo.save(cart);

	}

	@Override
	public void updateCust(PersonUpdateDto custDto, Long id) {
		System.out.println(id);
		custDto.setId(id);
		Customer customerEntity = custRepo.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException("customer by id " + id + " not present"));
		mapper.map(custDto, customerEntity);

	}

	@Override
	public PersonDto getCustomerDetails(Long customerId) {

		Customer customer = custRepo.findById(customerId)
				.orElseThrow(() -> new RuntimeException("Invalid Customer id !!!!!"));
		PersonDto person = mapper.map(customer, PersonDto.class);
		return person;
	}

	@Override
	public void deleteCustomer(Long customerId) {

		custRepo.deleteById(customerId);

	}

	// method called during customer login

	@Override

<<<<<<< HEAD
	public PersonLoginOutDto verifyCustomer(PersonLoginDto customerLoginDto) {
=======
	public PersonDtoWithRole verifyCustomer(PersonLoginDto customerLoginDto) {
>>>>>>> 4bcf322f1a801febac2e0c39bb339e122786b614

		Customer customer = custRepo.findByEmail(customerLoginDto.getEmail());
		if (customer == null)
			throw new CustomerNotFoundException("no such customer exists!");
		if (!customer.getPassword().equals(customerLoginDto.getPassword())) {
			throw new CustomerPasswordNotMatchingException("wrong password");
		}
<<<<<<< HEAD
		return mapper.map(customer, PersonLoginOutDto.class);

=======

		
		

		return mapper.map(customer, PersonDtoWithRole.class);


>>>>>>> 4bcf322f1a801febac2e0c39bb339e122786b614
	}

//	
}
