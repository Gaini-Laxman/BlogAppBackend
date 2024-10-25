package com.javafullstackguru.service;

import java.util.List;
import com.javafullstackguru.entity.Comments;

public interface CommentsService {

	Comments createComment(Comments comment);
	Comments findByCommentId(Integer id);
	List<Comments> getAllComments();
	Comments updateComment(Integer id, Comments comments);
	void deleteComment(Integer id);
	
	
}
