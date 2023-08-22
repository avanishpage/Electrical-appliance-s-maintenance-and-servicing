package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.PersonDto;
import com.app.dto.PersonLoginDto;
import com.app.dto.RatingDto;
import com.app.dto.ServiceDto;
import com.app.service.ServiceServiceLayerIF;
import com.app.service.VendorServiceLayerIF;

@RestController
@RequestMapping("/vendor")
public class VendorController {

	@Autowired
	private VendorServiceLayerIF vendorServiceLayer;

	@Autowired
	private ServiceServiceLayerIF serviceService;

	// create vendor
	@PostMapping("/add")
	public ApiResponse createVendor(@RequestBody @Valid PersonDto vendorDto) {

		vendorServiceLayer.addVendor(vendorDto);
		return new ApiResponse("Vendor is added successfully");

	}

	// put method for updating vendor information
	@PutMapping("/update/{id}")
	public ApiResponse updateVendor(@RequestBody PersonDto vendorDto, @PathVariable Long id) {

		vendorServiceLayer.updateVendor(vendorDto, id);
		return new ApiResponse("Vendor Updating");
	}

	// get method for getting vendor information
	@GetMapping("/{vendorId}")
	public PersonDto getVendorDetails(@PathVariable Long vendorId) {
		//System.out.println("in get customer " + vendorId);
		return vendorServiceLayer.getVendorDetails(vendorId);
	}

	// delete method for deleting vendor
	@DeleteMapping("/delete/{vendorId}")
	public ApiResponse deleteVendor(@PathVariable Long vendorId) {
		vendorServiceLayer.deleteVendor(vendorId);
		return new ApiResponse("Vendor deleted SIUUUU");
	}

	// post method for login
	@PostMapping("/login")
	public PersonDto loginVendor(@RequestBody PersonLoginDto vendorLoginDto) {
		return vendorServiceLayer.verifyVendor(vendorLoginDto);
	}

	@GetMapping("/services/{vendorId}")
	public List<ServiceDto> getServicesOfVendor(@PathVariable Long vendorId) {

		return vendorServiceLayer.getAllServicesOf(vendorId);
	}

	
	@PutMapping("/update/{vendorid}/service/{serviceId}")
	public ApiResponse updateServiceforVendor(@RequestBody ServiceDto servicedto, @PathVariable Long vendorid,@PathVariable Long serviceId) {

		vendorServiceLayer.updateServiceofVendor(servicedto, vendorid, serviceId);
		return new ApiResponse("Service"+ serviceId + "vendor" + vendorid + "updated successfully");
	} 
		
	
}
