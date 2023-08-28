package com.app.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.dto.PersonDto;
import com.app.dto.PersonDtoWithRole;
import com.app.dto.PersonLoginDto;
import com.app.dto.ServiceDto;

public interface VendorServiceLayerIF {
	
	public void addVendor(PersonDto custDto);

	public void updateVendor(PersonDto custDto, Long id);

	public PersonDto getVendorDetails(Long vendorId);

	public void deleteVendor(Long vendorId);

	public PersonDtoWithRole verifyVendor(PersonLoginDto vendorLoginDto);

	public List<ServiceDto> getAllServicesOf(Long vendorId);
	
	public void updateServiceofVendor(ServiceDto servicedto,Long vendorId, Long serviceId);

}
