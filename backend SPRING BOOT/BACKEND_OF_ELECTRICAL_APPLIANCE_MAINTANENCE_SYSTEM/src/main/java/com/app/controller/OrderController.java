package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.OrderDto;
import com.app.dto.ServiceDto;
import com.app.enums.JobStatus;
import com.app.service.OrderServiceIF;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderServiceIF orderService;
	
	
	
	@PostMapping("/add/cart/{cartId}")
	public ApiResponse createOrderFromCart(@PathVariable Long cartId) {	
		return orderService.addOrderFromCart(cartId);
		
	}
	
	@GetMapping("/{orderId}/services")
	public List<ServiceDto> getServicesOfOrder(@PathVariable Long orderId) {
		return orderService.getServices(orderId);
	}
	
	@GetMapping("/jobstatus")
	public List<OrderDto> getOrdersByJobStatus(@RequestParam JobStatus jobstatus){
		return orderService.getOrdersByJobStatus(jobstatus);		
	}
	

	@PatchMapping("/changeJobStatus/{orderId}")
	public ApiResponse changeJobStatus(@PathVariable Long orderId,@RequestParam JobStatus jobStatus) {
		return orderService.changeJobStatus(orderId,jobStatus );		
	}
	
	@GetMapping("/vendor/{vendorId}")
	public List<OrderDto> getOrdersByVendorId(@PathVariable Long vendorId){	
		return orderService.getAllOrdersOfVendor(vendorId);
	}
	
	@GetMapping("/{orderid}")
	public OrderDto getOrderById(@PathVariable Long orderId) {
		return orderService.getOrderBtOrderId(orderId);
	}

	@PatchMapping("/cancelOrder/{orderId}")
	public ApiResponse cancelOrder(@PathVariable Long orderId ) {
		return orderService.cancelOrder(orderId,JobStatus.COMPLETED );		
	}

}
