package com.app.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.ApiResponse;
import com.app.dto.ServiceDto;
import com.app.entity.Cart;
import com.app.entity.Order;
import com.app.enums.JobStatus;
import com.app.exceptions.CartNotFoundException;
import com.app.exceptions.OrderNotFoundException;
import com.app.repository.CartRepository;
import com.app.repository.OrderRepository;


@Service
@Transactional
public class OrderServiceImpl implements OrderServiceIF {
	
	@Autowired
	private CartRepository cartRepo;
	@Autowired
	private OrderRepository orderRepo;
	@Autowired
	private ModelMapper mapper;

	@Override
	public ApiResponse addOrderFromCart(Long cartId) {
		Cart cart= cartRepo.findById(cartId)
				.orElseThrow(()->new CartNotFoundException("invalid cart id!!"));
		
		Order order=new Order();
		
		com.app.entity.Service service=(com.app.entity.Service)cart.getServices().toArray()[0];
		
		order.setRelationWithCart(cart.getServices(),cart.getCustomer(),service.getVendor(),JobStatus.SCHEDULED);
				
		orderRepo.save(order);
		
		return new ApiResponse("order created successfully");
	}

	@Override
	public List<ServiceDto> getServices(Long orderId) {
		List<com.app.entity.Service> services=new ArrayList<>(orderRepo
				.findById(orderId).orElseThrow(()->new OrderNotFoundException("invalid order ID"))
				.getServices());
		
		List<ServiceDto> serviceDtos=new ArrayList<ServiceDto>();
		
		services.forEach(s->serviceDtos.add(mapper.map(s, ServiceDto.class)));
		
		return serviceDtos;
	}

}
