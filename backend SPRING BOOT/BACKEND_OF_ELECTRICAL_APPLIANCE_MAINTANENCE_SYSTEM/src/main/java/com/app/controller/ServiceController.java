package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.ServiceDto;
import com.app.service.ServiceServiceLayerIF;

@RestController
@RequestMapping("/service")
public class ServiceController {
	
	@Autowired
	private ServiceServiceLayerIF serviceService;

	//create and add a service to vendor
	@PostMapping("/add/{vendorId}")
	public ApiResponse addServiceToVendor(@Valid @RequestBody ServiceDto serviceDto,@PathVariable Long vendorId) {
		
		
		serviceService.attachServiceToVendor(serviceDto,vendorId);
		
		return new ApiResponse("service added to vendor successfully");
		
		
	}
	
	
}
