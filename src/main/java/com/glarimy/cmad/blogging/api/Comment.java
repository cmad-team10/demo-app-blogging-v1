package com.glarimy.cmad.blogging.api;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Comment {
	@Id
	@Column(name="commentId")
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int commentId;
	private int blogId;
	private String commentData;
	public Comment(int commentId, int blogId, String commentData) {
		super();
		this.commentId = commentId;
		this.blogId = blogId;
		this.commentData = commentData;
	}
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public String getCommentData() {
		return commentData;
	}
	public void setCommentData(String commentData) {
		this.commentData = commentData;
	}
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", blogId=" + blogId
				+ ", commentData=" + commentData + "]";
	}
	
	

}
