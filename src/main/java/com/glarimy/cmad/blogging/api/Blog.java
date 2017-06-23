package com.glarimy.cmad.blogging.api;

import java.util.List;
import java.util.Date;

import org.bson.types.ObjectId;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.PrePersist;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.annotations.Reference;
import org.mongodb.morphia.annotations.Validation;


import org.bson.types.ObjectId;


@Entity
@Validation("{ title : { $type : string },"
        + "blogText : {$type : string }")
public class Blog {
	@Id
	@Property("_id")
	private ObjectId blogId;
	private String blogIdString;
	public String getBlogIdString() {
		return blogIdString;
	}

	public void setBlogIdString(String blogIdString) {
		this.blogIdString = blogIdString;
	}
	private String title;

	private String details;
	private List<Comment> blogs;
	private String userId;
    private Date lastUpdatedOn;

	public Blog(ObjectId blogId, String title, String details, String userId) {
		super();
		this.blogId = blogId;
		this.title = title;
		this.details = details;
		this.userId = userId;
	}
	
	public Blog() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ObjectId getBlogId() {
		return blogId;
	}
	public void setBlogId(ObjectId blogId) {
		this.blogId = blogId;
	}
	public Date getLastUpdatedOn() {
	     return lastUpdatedOn;
	 }

	 public Blog setLastUpdatedOn(Date lastUpdatedOn) {
	      this.lastUpdatedOn = lastUpdatedOn;
	      return this;
	 }
	public String getTitle() {
		return title;
	}
	@PrePersist
	public void prePersist() {
	     this.lastUpdatedOn = new Date();
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Blog [blogId=" + blogId + ", title=" + title + ", details="
				+ details + ", userId=" + userId + "]";
	}
}
