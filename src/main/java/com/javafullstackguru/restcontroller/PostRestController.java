package com.javafullstackguru.restcontroller;

import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.javafullstackguru.entity.Post;
import com.javafullstackguru.service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostRestController {
	
	@Autowired
	private PostService postService;
	
	@PostMapping(value = "/createPost", 
            consumes = MediaType.APPLICATION_JSON_VALUE, 
            produces = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<Post> createPost(@RequestBody Post post) {
        // Your logic to save the post
        return ResponseEntity.status(HttpStatus.CREATED).body(post);
    }
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Post> getPostById(@PathVariable Integer id) {
	    Post post = postService.findByPostId(id);
	    return ResponseEntity.ok(post);
	}

	
	@GetMapping(value = "/allpost", 
            produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<Post>> getAllPost(){
    var post = postService.getAllPost();
    return new ResponseEntity<>(post, HttpStatus.OK);
}

	
	@PutMapping("/{id}")
	public ResponseEntity<Post> updatePost(@PathVariable Integer id, Post post){
		var updatePost = postService.updatePost(id, post);
		return new ResponseEntity<>(updatePost, HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Post> deletePost(@PathVariable Integer id){
		postService.deletePost(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	

}
