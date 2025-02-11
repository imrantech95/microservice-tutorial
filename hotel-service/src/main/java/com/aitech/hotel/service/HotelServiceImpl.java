package com.aitech.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aitech.hotel.entity.Hotel;
import com.aitech.hotel.exception.ResourceNotFoundException;
import com.aitech.hotel.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	HotelRepository hotelRepository;

	@Override
	public Hotel create(Hotel hotel) {
		return hotelRepository.save(hotel);
	}
	
	@Override
	public List<Hotel> saveHotels(List<Hotel> hotels) {
		return hotelRepository.saveAll(hotels);
	}

	public Hotel getHotelById(Integer hotelId) {
        return hotelRepository.findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with ID: " + hotelId));
    }

	@Override
	public List<Hotel> getAll() {
		return hotelRepository.findAll();
	}

}
