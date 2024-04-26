package com.example.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Rating {
	@Id
	private String userId;
	private int rating;
	private String comment;
	
	public Rating() {}
	
	 @JsonCreator
	    public Rating(@JsonProperty("userId") String userId,
	                  @JsonProperty("comment") String comment,
	                  @JsonProperty("rating") Integer rating
	                  ) {
	        this.userId = userId;
	        this.comment = comment;
	        this.rating = rating;
	    }

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}