package com.aitech.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aitech.hotel.entity.Hotel;
import com.aitech.hotel.service.HotelService;

@RestController
@RequestMapping("/hotel-api")
public class HotelController {

	@Autowired
	HotelService hotelService;

	@PostMapping("/create")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
		Hotel hotel1 = hotelService.create(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
	}

	@PostMapping("/save-multiple")
	public List<Hotel> saveMultipleUsers(@RequestBody List<Hotel> hotels) {
		return hotelService.saveHotels(hotels);
	}

	@GetMapping("/hotel/{hotelId}")
	public Hotel getHotelById(@PathVariable Integer hotelId) {
		return hotelService.getHotelById(hotelId);
	}

	@GetMapping("/hotels")
	public ResponseEntity<List<Hotel>> getAllHotels() {
		List<Hotel> allHotel = hotelService.getAll();
		return ResponseEntity.ok(allHotel);

	}
}
