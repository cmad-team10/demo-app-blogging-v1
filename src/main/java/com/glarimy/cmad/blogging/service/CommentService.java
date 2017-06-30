package com.glarimy.cmad.blogging.service;
import com.glarimy.cmad.blogging.api.EntityException;
import java.util.List;

import org.bson.types.ObjectId;

import com.glarimy.cmad.blogging.api.Comment;
import com.glarimy.cmad.blogging.api.CommentLibrary;
import com.glarimy.cmad.blogging.api.DataNotFoundException;
import com.glarimy.cmad.blogging.api.EntityException;
import com.glarimy.cmad.blogging.data.CommentLibraryDAO;
import com.glarimy.cmad.blogging.data.MongoCommentLibraryDAO;


public class CommentService  implements CommentLibrary{
	private CommentLibraryDAO commentdao= new MongoCommentLibraryDAO();

    @Override
    public Comment addComment(Comment comment) {
    	// TODO Auto-generated method stub
    	commentdao.createComment(comment);
    	return comment;
    }
    @Override
	public List<Comment> findComments(ObjectId blogid) {
		List<Comment> comments = commentdao.readComments(blogid);
		return comments;
	}
	@Override
	public Comment read(ObjectId commentId) throws DataNotFoundException, EntityException {
		// TODO Auto-generated method stub
		Comment comment = commentdao.read(commentId);
        if (comment == null)
            throw new DataNotFoundException();
        return comment;
	}
	@Override
	public Comment update(Comment comment) throws DataNotFoundException, EntityException {
		// TODO Auto-generated method stub
		commentdao.update(comment);

		return null;
	}
	@Override
	public void delete(ObjectId commentId) throws EntityException {
		// TODO Auto-generated method stub
		commentdao.delete(commentId);
		
	}
}
