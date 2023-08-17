package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.dto.PersonDto;
import com.app.dto.PersonLoginDto;
import com.app.entity.Vendor;
import com.app.exceptions.VendorNotFoundException;
import com.app.exceptions.VendorPasswordNotMatchingException;
import com.app.repository.VendorRepositoryIF;

public class VendorServiceLayerImpl implements VendorServiceLayerIF{

	
	@Autowired
	private VendorRepositoryIF vendorRepo;
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public void addVendor(PersonDto vendorDto) {
		
		Vendor vendorEntity=new Vendor();
				mapper.map(vendorDto, vendorEntity);
		
				vendorRepo.save(vendorEntity);
		
	}

	@Override
	public void updateVendor(PersonDto vendorDto, Long id) {
		System.out.println(id);
		
		Vendor vendorEntity=vendorRepo.findById(id).orElseThrow(()->  new VendorNotFoundException("vendor by id "+id+" not present"));
		mapper.map(vendorDto, vendorEntity);
	}

	@Override
	public PersonDto getVendorDetails(Long vendorId) {

		return mapper.map(vendorRepo.findById(vendorId).orElseThrow(() -> new RuntimeException("Invalid vendor id !!!!!")),PersonDto.class) ;

	}

	@Override
	public void deleteVendor(Long vendorId) {

		vendorRepo.deleteById(vendorId);
		
	}

	@Override
	public PersonDto verifyVendor(PersonLoginDto vendorLoginDto) {
		
		Vendor vendor= vendorRepo.findByEmail(vendorLoginDto.getEmail());
		if(vendor==null)
			throw new VendorNotFoundException("invalid email!!");
		if(!vendor.getPassword().equals(vendorLoginDto.getPassword()))
			throw new VendorPasswordNotMatchingException("wrong password!!");
		
		return mapper.map(vendor, PersonDto.class);
		
		
	}

}
