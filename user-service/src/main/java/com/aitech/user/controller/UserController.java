package com.aitech.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aitech.user.entity.User;
import com.aitech.user.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;

	//create user
	@PostMapping("/user")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User user1 = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}

	//get Single user
	@GetMapping("/user/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable Integer userId) {
		User user = userService.getUser(userId);
		return ResponseEntity.ok(user);
	}

	//get all user(
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> allUser = userService.getAllUser();
		return ResponseEntity.ok(allUser);	
	}
	
	@PutMapping("user/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Integer userId, @RequestBody User updatedUser) {
        User user = userService.updateUser(userId, updatedUser);
        return ResponseEntity.ok(user);
    }
	
	@DeleteMapping("user/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer userId) {
	    userService.deleteUser(userId);
	    return ResponseEntity.ok("User deleted successfully");
	}
}
