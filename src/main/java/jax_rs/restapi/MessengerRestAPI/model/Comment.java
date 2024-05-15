package jax_rs.restapi.MessengerRestAPI.model;

import java.util.Date;

public class Comment {
	
	private long id;
	private String message;
	private Date createdDate;
	private String author;
	
	public Comment() {
		super();
	}
	
	public Comment(long id, String message, String author) {
		super();
		this.id = id;
		this.message = message;
		this.author = author;
		this.createdDate = new Date();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long messageId) {
		this.id = messageId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
}
