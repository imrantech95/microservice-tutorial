package com.aitech.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {

	private Integer hotelId;
	private String name;
	private String location;
	private String about;
}
