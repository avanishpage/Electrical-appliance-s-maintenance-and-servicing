package com.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.PersonDto;
import com.app.dto.PersonLoginDto;
import com.app.dto.RatingDto;
import com.app.dto.ServiceDto;
import com.app.entity.Rating;
import com.app.entity.Vendor;
import com.app.exceptions.ResourceNotFound;
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

		return mapper.map(vendorRepo.findById(vendorId).orElseThrow(() -> new VendorNotFoundException("Invalid vendor id !!!!!")),PersonDto.class) ;

	}

	@Override
	public void deleteVendor(Long vendorId) {

		vendorRepo.deleteById(vendorId);
		
	}

	//method called during vendor login
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


	@Override
	public void updateServiceofVendor(ServiceDto servicedto, Long vendorId, Long serviceId) {

		Vendor vendor = vendorRepo.findById(vendorId).orElseThrow(()->new VendorNotFoundException("invalid vendor id"));
		
		com.app.entity.Service service = vendor.getServices().stream()
                .filter(p -> p.getId().equals(serviceId))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFound("Service not found for this vendor"));
		
		mapper.map(servicedto,service);
		serviceRepo.save(service);
		
	
}

//	@Override
//	public List<RatingDto> getVendorRating(Long vendorId) {
//		Vendor vendor = vendorRepo.findById(vendorId).orElseThrow(()->new VendorNotFoundException("invalid vendor id"));
//		List<Rating> rating=vendor.getRatings();
//		rating.size();
//		List<RatingDto> ratingDto = new ArrayList<>();
//		
//		rating.forEach((r)->ratingDto.add(mapper.map(r, RatingDto.class)));
//		return ratingDto;
//	}
	
}
