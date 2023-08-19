package com.app.service;

import com.app.dto.ApiResponse;
import com.app.dto.ServiceDto;

public interface ServiceServiceLayerIF {

	void attachServiceToVendor(ServiceDto serviceDto, Long vendorId);

	ApiResponse deleteServiceUsingVendorId(Long vendorId, Long serviceId);

}
