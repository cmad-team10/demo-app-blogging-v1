package com.glarimy.cmad.blogging.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.glarimy.cmad.blogging.api.Comment;
import com.glarimy.cmad.blogging.api.CommentLibrary;
import com.glarimy.cmad.blogging.data.CommentLibraryDAO;
import com.glarimy.cmad.blogging.data.MongoCommentLibraryDAO;

public class CommentService  implements CommentLibrary{
	private CommentLibraryDAO commentdao= new MongoCommentLibraryDAO();

    @Override
    public void addComment(Comment comment) {
    	// TODO Auto-generated method stub
    	commentdao.createComment(comment);
    }
    @Override
	public List<Comment> findComments(ObjectId blogid) {
		List<Comment> comments = commentdao.readComments(blogid);
		return comments;
	}
}
