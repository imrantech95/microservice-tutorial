package com.aitech.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aitech.hotel.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer>{

}
