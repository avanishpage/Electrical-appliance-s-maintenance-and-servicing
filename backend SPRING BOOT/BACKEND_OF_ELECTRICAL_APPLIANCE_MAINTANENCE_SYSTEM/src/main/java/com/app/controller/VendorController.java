package com.app.controller;

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

import com.app.dto.*;
import com.app.service.VendorServiceLayerIF;

@RestController
@RequestMapping("/vendor")
public class VendorController {

	@Autowired
	private VendorServiceLayerIF serviceLayer;
	
	//create vendor
	@PostMapping("/add")
	public void createVendor(@RequestBody @Valid PersonDto vendorDto) {

		serviceLayer.addVendor(vendorDto);

	}

	//put method for updating vendor information
	@PutMapping("/update/{id}")
	public void updateVendor(@RequestBody PersonDto vendorDto, @PathVariable Long id) {

		serviceLayer.updateVendor(vendorDto, id);
	}

	//get method for getting vendor information
	@GetMapping("/{vendorId}")
	public PersonDto getVendorDetails(@PathVariable Long vendorId) {
		System.out.println("in get customer " + vendorId);
		return serviceLayer.getVendorDetails(vendorId);
	}

	//delete method for deleting vendor
	@DeleteMapping("/delete/{vendorId}")
	public void deleteVendor(@PathVariable Long vendorId) {
		serviceLayer.deleteVendor(vendorId);
	}
	
	//post method for login
	@PostMapping("/login")
	public PersonDto loginVendor(@RequestBody PersonLoginDto vendorLoginDto) {
		return serviceLayer.verifyVendor(vendorLoginDto);
	}
	
	
	
	
	
	
	

}
