package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.dto.CustomerDto;
import com.app.entity.Customer;
import com.app.entity.Vendor;
import com.app.exceptions.CustomerNotFoundException;
import com.app.exceptions.VendorNotFoundException;
import com.app.repository.VendorRepositoryIF;

public class VendorServiceLayerImpl implements VendorServiceLayerIF{

	
	@Autowired
	private VendorRepositoryIF vendorRepo;
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public void addVendor(CustomerDto custDto) {
		
		Vendor vendorEntity=new Vendor();
				mapper.map(custDto, vendorEntity);
		
				vendorRepo.save(vendorEntity);
		
	}

	@Override
	public void updateVendor(CustomerDto custDto, Long id) {
		System.out.println(id);
		
		Vendor vendorEntity=vendorRepo.findById(id).orElseThrow(()->  new VendorNotFoundException("vendor by id "+id+" not present"));
		mapper.map(custDto, vendorEntity);
	}

	@Override
	public Vendor getVendorDetails(Long vendorId) {

		return vendorRepo.findById(vendorId).orElseThrow(() -> new RuntimeException("Invalid vendor id !!!!!"));

	}

	@Override
	public void deleteVendor(Long vendorId) {

		vendorRepo.deleteById(vendorId);
		
	}

}
