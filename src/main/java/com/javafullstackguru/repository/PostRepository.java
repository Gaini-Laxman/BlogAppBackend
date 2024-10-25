package com.javafullstackguru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.javafullstackguru.entity.Post;


@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{
      
	
}
