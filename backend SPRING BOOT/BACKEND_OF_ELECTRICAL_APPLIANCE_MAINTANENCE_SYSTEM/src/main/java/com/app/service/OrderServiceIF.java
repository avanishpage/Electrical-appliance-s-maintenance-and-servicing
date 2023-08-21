package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.app.dto.ApiResponse;
import com.app.dto.ServiceDto;


public interface OrderServiceIF {

	public ApiResponse addOrderFromCart(Long cartId);

	public List<ServiceDto> getServices(Long orderId);
	

}
