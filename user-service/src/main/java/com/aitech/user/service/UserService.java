package com.aitech.user.service;

import java.util.List;

import com.aitech.user.entity.User;

public interface UserService {

	// create
	User saveUser(User user);

	// get list user
	List<User> getAllUser();

	//get single user by id
	User getUser(Integer userId);
	
	//update user
	User updateUser(Integer userId, User updatedUser);
	
	//Delete user
	void deleteUser(Integer userId);
	
}
