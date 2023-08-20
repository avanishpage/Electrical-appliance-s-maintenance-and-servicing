package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.RatingDto;
import com.app.service.RatingServiceIF;

@RestController
@RequestMapping("/rating")
public class RatingController {
	
	@Autowired
	private RatingServiceIF ratingService;
	
	@PostMapping("/add/{order_id}")
	public ApiResponse giveRating(@RequestBody RatingDto ratingdto,@PathVariable Long order_id) {

		ratingService.addRating(ratingdto, order_id);
		
		return new ApiResponse("Rating added for customer");
		
	}
	

}
