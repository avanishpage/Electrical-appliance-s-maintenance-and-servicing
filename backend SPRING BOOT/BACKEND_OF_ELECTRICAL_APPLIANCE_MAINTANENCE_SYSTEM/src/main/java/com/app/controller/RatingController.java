package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.RatingDto;
import com.app.service.RatingServiceIF;
import com.app.service.VendorServiceLayerIF;

@RestController
@RequestMapping("/rating")
public class RatingController {
	
	@Autowired
	private RatingServiceIF ratingService;
	
	@Autowired
	private VendorServiceLayerIF vendorServiceLayer;
	
	@PostMapping("/add/{order_id}")
	public ApiResponse giveRating(@RequestBody RatingDto ratingdto,@PathVariable Long order_id) {

		ratingService.addRating(ratingdto, order_id);
		
		return new ApiResponse("Rating added for customer");
		
	}
	
<<<<<<< HEAD
	@GetMapping("/average/{vendor_id}")
	public Double getAverageRating(@PathVariable Long vendor_id) {
		
=======
	@GetMapping("/{vendor_id}")
	public Double getAverageRating(@PathVariable Long vendor_id) {
		
	//	System.out.println(vendor_id);
>>>>>>> 898a27059c7f585f324c9eb891022324fca41bc7
	return ratingService.calculateAverageRatingforVendor(vendor_id);
		
	}
	
	@GetMapping("/order/{order_id}")
	public RatingDto getRatingForOrder(@PathVariable Long order_id) {
		
		return ratingService.getRatingForOrder(order_id);
		
	}
<<<<<<< HEAD
	
	@GetMapping("/{vendorId}")
	public List<RatingDto> getRatingOfVendor(@PathVariable Long vendorId)
	{
		return vendorServiceLayer.getVendorRating(vendorId);
	}
=======
>>>>>>> 898a27059c7f585f324c9eb891022324fca41bc7

}
