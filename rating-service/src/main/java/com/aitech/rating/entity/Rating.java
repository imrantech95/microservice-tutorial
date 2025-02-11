package com.aitech.rating.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rating_micro")
public class Rating {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ratingId;

	private Integer userId;
	private Integer hotelId;
	private Integer rating;
	private String feedback;

}
