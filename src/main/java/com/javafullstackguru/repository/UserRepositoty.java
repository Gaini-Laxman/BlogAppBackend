package com.javafullstackguru.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.javafullstackguru.entity.User;

@Repository
public interface UserRepositoty extends JpaRepository<User, Integer> {
	
	 Optional<User> findByUsername(String username);

}