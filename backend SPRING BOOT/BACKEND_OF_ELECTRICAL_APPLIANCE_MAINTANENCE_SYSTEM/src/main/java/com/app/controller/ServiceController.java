package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.ServiceDto;
import com.app.entity.Service;
import com.app.enums.Category;
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
	
	@GetMapping("/category")
	public List<ServiceDto> getServiceByCategory(@RequestParam Category category){
		
		return serviceService.getServicesByCategory(category);
	}
	
	@DeleteMapping("/{serviceId}/vendor/{vendorId}/delete/")

	public ApiResponse deleteServiceOfVendorId(@PathVariable Long vendorId,@PathVariable Long serviceId ) {
	
		return serviceService.deleteServiceUsingVendorId(vendorId, serviceId);
	}
	
	
	
	
}
