package com.aitech.rating.service;

import java.util.List;

import com.aitech.rating.entity.Rating;

public interface RatingService {

	// create
	Rating create(Rating rating);

	// get rating by userId
	List<Rating> getRatingByUserId(Integer userId);

	// get All ratings
	List<Rating> getAllRatings();

	// get rating by hotelId
	List<Rating> getRatingByHotelId(Integer hotelId);




}
