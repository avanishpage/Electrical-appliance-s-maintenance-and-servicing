package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.ServiceDto;
import com.app.entity.Service;
import com.app.enums.Category;

public interface ServiceServiceLayerIF {

	void attachServiceToVendor(ServiceDto serviceDto, Long vendorId);

	ApiResponse deleteServiceUsingVendorId(Long vendorId, Long serviceId);
	
	List<ServiceDto> getServicesByCategory(Category category);

	List<Category> getAllCategories();

	List<ServiceDto> getServicesByCity(String city);

}
