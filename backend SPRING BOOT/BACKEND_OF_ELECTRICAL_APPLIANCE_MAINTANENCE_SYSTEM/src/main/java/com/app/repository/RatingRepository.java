package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long>{

}
