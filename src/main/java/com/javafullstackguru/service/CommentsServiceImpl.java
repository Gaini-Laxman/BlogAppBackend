package com.javafullstackguru.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javafullstackguru.entity.Comments;
import com.javafullstackguru.exception.ResourceNotFoundException;
import com.javafullstackguru.repository.CommentsRepository;

@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private CommentsRepository commentsRepository;

    @Override
    public Comments createComment(Comments comment) {
        return commentsRepository.save(comment);
    }

    @Override
    public Comments findByCommentId(Integer id) {
        return commentsRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Comment not found with id: " + id));
    }

    @Override
    public List<Comments> getAllComments() {
        return commentsRepository.findAll();
    }

    @Override
    public Comments updateComment(Integer id, Comments updatedComment) {
        if (!commentsRepository.existsById(id)) {
            throw new ResourceNotFoundException("Comment not found with id: " + id);
        }
        updatedComment.setId(id); // Ensure the ID is set for the update
        return commentsRepository.save(updatedComment);
    }

    @Override
    public void deleteComment(Integer id) { // Renamed for conciseness
        if (!commentsRepository.existsById(id)) {
            throw new ResourceNotFoundException("Comment not found with id: " + id);
        }
        commentsRepository.deleteById(id);
    }
}
