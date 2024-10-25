package com.javafullstackguru.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.javafullstackguru.entity.Post;
import com.javafullstackguru.exception.ResourceNotFoundException;
import com.javafullstackguru.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    @Transactional // Add transaction management
    public Post createPost(Post post) { // Fixed spelling
        return postRepository.save(post);
    }

    @Override
    public Post findByPostId(Integer id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post Not Found with Id: " + id));
    }

    @Override
    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    @Override
    @Transactional // Ensure that the update is transactional
    public Post updatePost(Integer id, Post post) {
        if (!postRepository.existsById(id)) {
            throw new ResourceNotFoundException("Post Not Found with id: " + id);
        }
        post.setId(id); // Ensure the ID is set for the update
        return postRepository.save(post);
    }

    @Override
    @Transactional // Ensure the delete operation is transactional
    public void deletePost(Integer id) {
        if (!postRepository.existsById(id)) {
            throw new ResourceNotFoundException("Post Not Found with id: " + id);
        }
        postRepository.deleteById(id);
    }
}
