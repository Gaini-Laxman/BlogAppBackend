package com.javafullstackguru.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.javafullstackguru.entity.Comments;
import com.javafullstackguru.service.CommentsService;

@RestController
@RequestMapping("/api/comments")
public class CommentsRestController {

    @Autowired
    private CommentsService commentsService;

    @PostMapping("/createcomment")
    public ResponseEntity<Comments> createComment(@RequestBody Comments comments) {
        Comments createdComment = commentsService.createComment(comments);
        return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comments> findByCommentId(@PathVariable Integer id) {
        Comments comment = commentsService.findByCommentId(id);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @GetMapping("/allcomments") // Added leading slash
    public ResponseEntity<List<Comments>> getAllComments() {
        List<Comments> allComments = commentsService.getAllComments();
        return new ResponseEntity<>(allComments, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comments> updateComment(@PathVariable Integer id, @RequestBody Comments comments) {
        Comments updatedComment = commentsService.updateComment(id, comments);
        return new ResponseEntity<>(updatedComment, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Integer id) { // Updated return type
        commentsService.deleteComment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
