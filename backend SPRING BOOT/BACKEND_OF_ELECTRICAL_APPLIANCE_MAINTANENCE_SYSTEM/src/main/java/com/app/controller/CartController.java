package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.ServiceDto;
import com.app.service.CartServiceIF;

@RestController
@RequestMapping("/cart/{cartId}")
public class CartController {

	@Autowired
	private CartServiceIF cartServiceLayer;

	@PostMapping("/add/service/{serviceId}")
	public ApiResponse addServiceToCart(@PathVariable Long cartId, @PathVariable Long serviceId) {

		return cartServiceLayer.addServiceToACart(cartId, serviceId);

	}
	
	@GetMapping("/services")
	public List<ServiceDto> getServicesFromCart(@PathVariable Long cartId){
		
		return cartServiceLayer.getAllServicesFromCart(cartId);
		
	}
	
	@DeleteMapping("/delete/service/{serviceId}")
	public ApiResponse deleteServiceFromCart(@PathVariable Long cartId,@PathVariable Long serviceId) {
		return cartServiceLayer.removeServiceFromCart(cartId,serviceId);
	}

}
