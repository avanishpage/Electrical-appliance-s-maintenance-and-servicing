package com.app.service;

import com.app.dto.PersonDto;
import com.app.dto.PersonLoginDto;
import com.app.entity.Vendor;

public interface VendorServiceLayerIF {
	
	public void addVendor(PersonDto custDto);

	public void updateVendor(PersonDto custDto, Long id);

	public PersonDto getVendorDetails(Long vendorId);

	public void deleteVendor(Long vendorId);

	public PersonDto verifyVendor(PersonLoginDto vendorLoginDto);

}
