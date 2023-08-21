package com.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.ApiResponse;
import com.app.dto.ServiceDto;
import com.app.entity.Cart;
import com.app.exceptions.CartNotFoundException;
import com.app.exceptions.ServiceNotFoundException;
import com.app.repository.CartRepository;
import com.app.repository.ServiceRepositoryIF;


@Service
@Transactional
public class CartServiceImpl implements CartServiceIF{
	@Autowired
	private ServiceRepositoryIF serviceRepo;
	@Autowired
	private CartRepository cartRepo;
	@Autowired
	private ModelMapper mapper;

	@Override
	public ApiResponse addServiceToACart(Long cartId, Long serviceId) {
		
		com.app.entity.Service service=serviceRepo.findById(serviceId).orElseThrow(()->new com.app.exceptions.ServiceNotFoundException("invalid service ID"));

		Cart cart=cartRepo.findById(cartId).orElseThrow(()->new CartNotFoundException("no such cart exists"));
		
		cart.associateServiceWithCart(service);
		return new ApiResponse("service added successfully to the cart");
		
	}

	@Override
	public List<ServiceDto> getAllServicesFromCart(Long cartId) {
		List<com.app.entity.Service> services= new ArrayList<>(cartRepo.findById(cartId).
				orElseThrow(()->new CartNotFoundException("invalid Cart Id")).
				getServices());
		
		List<ServiceDto> serviceDtos=new ArrayList<>();
		
		services.forEach(s->serviceDtos.add(mapper.map(s, ServiceDto.class)));
		
		return serviceDtos;
	}

	@Override
	public ApiResponse removeServiceFromCart(Long cartId, Long serviceId) {
		Cart cart=cartRepo.findById(cartId).orElseThrow(()->new CartNotFoundException("Invalid Cart Id"));

		com.app.entity.Service service=serviceRepo.findById(serviceId).orElseThrow(()->new ServiceNotFoundException("Invalid Service Id"));
		
		cart.disassociateServiceWithCart(service);
		
		return new ApiResponse("service removed Successfully!!");
	}

}
