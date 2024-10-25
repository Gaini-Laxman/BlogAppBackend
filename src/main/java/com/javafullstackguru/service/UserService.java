package com.javafullstackguru.service;

import java.util.List;

import com.javafullstackguru.entity.User;

public interface UserService {
	User createUser(User user);
	User findByUserId(Integer id);
	List<User> findAllUsers();
	User updateUser(Integer id, User user);
	void deleteUser(Integer id);
	
	

}
