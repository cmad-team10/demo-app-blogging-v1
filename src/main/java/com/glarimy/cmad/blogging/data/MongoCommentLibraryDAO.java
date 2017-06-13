package com.glarimy.cmad.blogging.data;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

import com.glarimy.cmad.blogging.api.Blog;
import com.glarimy.cmad.blogging.api.Comment;
import com.mongodb.MongoClient;

public class MongoCommentLibraryDAO extends BasicDAO<Comment, Long> implements CommentLibraryDAO {
	private static MongoClient mongoClient =  new MongoClient("localhost", 27017);;
    private static Morphia morphia = new Morphia();
    private static Datastore dataStore = morphia.createDatastore(mongoClient, "cmad");
    
	public MongoCommentLibraryDAO(Class<Comment> entityClass, Datastore ds) {
		super(entityClass, ds);
		// TODO Auto-generated constructor stub
	}
	
	public MongoCommentLibraryDAO() {
        this(Comment.class, dataStore);
	}
	

	@Override
	public void createComment(Comment comment) {
		// TODO Auto-generated method stub
		save(comment);
		
	}

	@Override
	public List<Comment> readComments(int blogId) {
		// TODO Auto-generated method stub
		List<Comment> comments = createQuery().filter("blog", blogId).asList();
        return comments;
	}

}
