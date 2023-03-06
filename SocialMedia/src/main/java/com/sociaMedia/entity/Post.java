package com.sociaMedia.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "posts") // annotations to map to the corresponding database table "posts"
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)   // Post class has a many-to-one relationship with the User class, so each post has an author
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@Column(name = "message", nullable = false) // "message" is a required field and cannot be null
	private String message;

	@Column(name = "created_at") // "created_at" is a required field and cannot be null
	private LocalDateTime createdAt;
	
//	@Column(name = "feeling") 
//	private String feeling;
//	
//	@Column(name = "game") 
//	private String game;

    // constructor with user first name and message 

    public Post(User user, String message) {
        this.user = user;
        this.message = message;
    }
    
    // default constructor 
    public Post() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

//	public String getFeeling() {
//		return feeling;
//	}
//
//	public void setFeeling(String feeling) {
//		this.feeling = feeling;
//	}
//
//	public String getGame() {
//		return game;
//	}
//
//	public void setGame(String game) {
//		this.game = game;
//	}

	
}
