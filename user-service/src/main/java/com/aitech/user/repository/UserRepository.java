package com.aitech.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aitech.user.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
}
