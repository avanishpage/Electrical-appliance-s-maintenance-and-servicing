package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.ApiResponse;
import com.app.dto.ServiceDto;
import com.app.entity.Vendor;
import com.app.exceptions.ServiceNotFoundException;
import com.app.exceptions.VendorNotFoundException;
import com.app.repository.ServiceRepositoryIF;
import com.app.repository.VendorRepositoryIF;

@Service
@Transactional
public class ServiceServiceImpl implements ServiceServiceLayerIF {
	@Autowired
	private ServiceRepositoryIF serviceRepo;
	@Autowired
	private VendorRepositoryIF vendorRepo;
	@Autowired
	private ModelMapper mapper;

	@Override
	public void attachServiceToVendor(ServiceDto serviceDto, Long vendorId) {
		
		System.out.println(serviceDto);
		
		
		Vendor vendor=vendorRepo.findById(vendorId).orElseThrow(()->new VendorNotFoundException("invalid vendor id!!"));
		
		com.app.entity.Service service= new com.app.entity.Service();
		service=mapper.map(serviceDto, com.app.entity.Service.class);
		serviceRepo.save(service);
		
		vendor.addService(service);
		
	}

	@Override
	 public ApiResponse  deleteServiceUsingVendorId(Long vendorId, Long serviceId) {
		
	        Vendor vendor=vendorRepo.findById(vendorId).orElseThrow(()->new VendorNotFoundException("invalid vendor id!!"));
	        com.app.entity.Service service=serviceRepo.findById(serviceId).orElseThrow(()->new ServiceNotFoundException("invalid serviceW id!!"));
	        
	        vendor.deleteService(service);
	        serviceRepo.delete(service);

	        return new ApiResponse("Service deleted successfully");
	    }
	}
	





