package com.sociaMedia.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "comments") // annotations to map to the corresponding database table "comments"
public class Comment { // Comment: a class to represent comments made on posts

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "content", nullable = false) // "content" is required field and cannot be null
	private String content;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false) // "user_id" is required field and cannot be null
	private User user;

	@ManyToOne
	@JoinColumn(name = "post_id", nullable = false) // "post_id" is required field and cannot be null
	private Post post;

	@Column(name = "created_at", nullable = false) // "created_at" is required field and cannot be null
	private LocalDateTime createdAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

}
