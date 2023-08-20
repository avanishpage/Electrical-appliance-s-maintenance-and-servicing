package com.app.service;

import com.app.dto.ServiceDto;

public interface ServiceServiceLayerIF {

	void attachServiceToVendor(ServiceDto serviceDto, Long vendorId);

	//void updateService()
}
