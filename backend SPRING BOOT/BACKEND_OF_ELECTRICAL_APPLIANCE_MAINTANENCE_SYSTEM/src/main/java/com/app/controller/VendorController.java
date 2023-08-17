package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.dto.CustomerDto;
import com.app.entity.Vendor;
import com.app.service.VendorServiceLayerIF;

@RestController
@RequestMapping("/vendor")
public class VendorController {


	@Autowired
	private VendorServiceLayerIF serviceLayer;


	@PostMapping("/add")
	public void createVendor(@RequestBody @Valid CustomerDto custDto) {
		
		serviceLayer.addVendor(custDto);
		
	}
	
	@PutMapping("/update/{id}")
	public void updateVendor(@RequestBody CustomerDto custDto,@PathVariable Long id) {
		
		serviceLayer.updateVendor(custDto,id);
	}
	
	
	   @GetMapping("/{vendorId}") 
		public Vendor getEmpDetails(@PathVariable Long vendorId) {
			System.out.println("in get customer " + vendorId);
			return serviceLayer.getVendorDetails(vendorId);
		}
	    
	    @DeleteMapping("/{vendorId}")
	    public void deleteCustomer(@PathVariable Long customerId) {
	    	serviceLayer.deleteVendor(customerId);
	    }
	
}
