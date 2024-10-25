package com.javafullstackguru.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javafullstackguru.entity.Comments;

public interface CommentsRepository extends JpaRepository<Comments, Integer>{
	

}
