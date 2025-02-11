package com.aitech.hotel.service;

import java.util.List;

import com.aitech.hotel.entity.Hotel;

public interface HotelService {

	// create
	Hotel create(Hotel hotel);

	// getById
	Hotel getHotelById(Integer hotelId);

	// getAll
	List<Hotel> getAll();

	List<Hotel> saveHotels(List<Hotel> hotels);

}
