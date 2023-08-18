package com.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.PersonDto;
import com.app.dto.PersonLoginDto;
import com.app.dto.ServiceDto;
import com.app.entity.Vendor;
import com.app.exceptions.VendorNotFoundException;
import com.app.exceptions.VendorPasswordNotMatchingException;
import com.app.repository.ServiceRepositoryIF;
import com.app.repository.VendorRepositoryIF;

@Service
@Transactional
public class VendorServiceLayerImpl implements VendorServiceLayerIF{

	
	@Autowired
	private VendorRepositoryIF vendorRepo;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private ServiceRepositoryIF serviceRepo;
	
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

	@Override
	public List<ServiceDto> getAllServicesOf(Long vendorId) {
		
		Vendor vendor=vendorRepo.findById(vendorId).orElseThrow(()->new VendorNotFoundException("invalid vendor id"));
		
		List<com.app.entity.Service> services=vendor.getServices();
		services.size();
		
		List<ServiceDto> servicesDto=new ArrayList<>();
		
		services.forEach((s)->servicesDto.add(mapper.map(s, ServiceDto.class)));
		return servicesDto;
	}

}