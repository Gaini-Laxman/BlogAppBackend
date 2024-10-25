package com.javafullstackguru.service;

import java.util.List;
import com.javafullstackguru.entity.Post;

public interface PostService {
	
	Post createPost(Post post);
	Post findByPostId(Integer id);
	List<Post> getAllPost();
	Post updatePost(Integer id, Post post);
	void deletePost(Integer id);
	
}
