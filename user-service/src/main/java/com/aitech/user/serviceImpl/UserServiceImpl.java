package com.aitech.user.serviceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aitech.user.customException.ResourceNotFoundException;
import com.aitech.user.entity.Hotel;
import com.aitech.user.entity.Rating;
import com.aitech.user.entity.User;
import com.aitech.user.repository.UserRepository;
import com.aitech.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RestTemplate restTemplate;

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	// get single user
	@Override
	public User getUser(Integer userId) {

		// get user for the database with the help of user repository
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with userId " + userId));

		// fetch rating of the above user from RATING-SERVICE
		// http://localhost:8083/api-rating/user/1

		Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/api-rating/user/" + user.getUserId(),
				Rating[].class);
		logger.info("response status code {}: ", ratingsOfUser);

		List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();

		
		List<Rating> ratingList = ratings.stream().map(rating -> {

			// api call to hotel service to get hotel //
			// http://localhost:8082/hotel-api/hotel/2
			ResponseEntity<Hotel> forEntity = restTemplate
					.getForEntity("http://HOTEL-SERVICE/hotel-api/hotel/" + rating.getHotelId(), Hotel.class);
			Hotel hotel = forEntity.getBody();
			logger.info("Response status code {} ", forEntity.getStatusCode());

			// set the hotel to rating
			rating.setHotel(hotel);

			// return rating

			return rating;
		}).collect(Collectors.toList());

		user.setRating(ratingList);

		return user;
	}

	@Override
	public User updateUser(Integer userId, User updatedUser) {
		return userRepository.findById(userId).map(existingUser -> {
			existingUser.setName(updatedUser.getName());
			existingUser.setEmail(updatedUser.getEmail());
			existingUser.setAbout(updatedUser.getAbout());
			// Add other fields as needed
			return userRepository.save(existingUser);
		}).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
	}

	@Override
	public void deleteUser(Integer userId) {
		if (!userRepository.existsById(userId)) {
			throw new ResourceNotFoundException("User not found with id :" + userId);
		}
		userRepository.deleteById(userId);

	}
}
