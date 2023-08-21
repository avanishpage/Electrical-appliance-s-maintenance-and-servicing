package com.app.service;

import com.app.dto.RatingDto;
import com.app.entity.Rating;

public interface RatingServiceIF {

	public void addRating(RatingDto ratingdto, Long order_id);

	public Double calculateAverageRatingforVendor(Long vendorId);
}
