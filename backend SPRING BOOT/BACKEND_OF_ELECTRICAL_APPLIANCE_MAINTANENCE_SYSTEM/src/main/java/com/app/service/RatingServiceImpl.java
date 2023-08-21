package com.app.service;


import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.RatingDto;
import com.app.entity.Order;
import com.app.entity.Rating;
import com.app.entity.Vendor;
import com.app.exceptions.OrderNotFoundException;

import com.app.exceptions.VendorNotFoundException;

import com.app.repository.OrderRepositoryIF;
import com.app.repository.RatingRepository;
import com.app.repository.VendorRepositoryIF;

@Service
@Transactional
public class RatingServiceImpl implements RatingServiceIF {

	@Autowired
	private RatingRepository ratingRepo;
	
	@Autowired
	private OrderRepositoryIF orderRepo;
	
	@Autowired

	private VendorRepositoryIF vendorRepo;
	
	@Autowired

	private ModelMapper mapper;
	
	@Override
	public void addRating(RatingDto ratingdto, Long order_id) {
		Order order = orderRepo.findById(order_id).orElseThrow(()-> new OrderNotFoundException("Order Not Found"));
		
		System.out.println(order.getVendor());
		
		Rating rating = new Rating();
//		System.out.println(ratingdto.getDescription() + " " + ratingdto.getStars());
		rating.setStars(ratingdto.getStars());
		rating.setDescription(ratingdto.getDescription());
//		
//		rating.setId(order_id);
//		mapper.map(ratingdto, rating);
//		
		
		
		Vendor vendor = order.getVendor();
		vendor.addRating(rating);
		order.giveRating(rating);
		
		ratingRepo.save(rating);
				
	}

	@Override
	public Double calculateAverageRatingforVendor(Long vendorId) {

		Vendor vendor = vendorRepo.findById(vendorId).orElseThrow(()-> new VendorNotFoundException("Vendor not found"));
		List<Rating> ratings= vendor.getRatings();		
		
		if(ratings.isEmpty()) {
			return 0.0;
		}
		
		double totalRating = ratings.stream().mapToInt(rating -> rating.getStars().ordinal()).sum();
		
		return totalRating/ratings.size();
	
	}

=======
}
