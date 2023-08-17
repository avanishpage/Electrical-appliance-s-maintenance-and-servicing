package com.app.service;

import com.app.dto.CustomerDto;
import com.app.entity.Vendor;

public interface VendorServiceLayerIF {
	
	void addVendor(CustomerDto custDto);

	void updateVendor(CustomerDto custDto, Long id);

	Vendor getVendorDetails(Long vendorId);

	void deleteVendor(Long vendorId);

}
