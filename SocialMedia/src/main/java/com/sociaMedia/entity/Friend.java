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
@Table(name = "friends") // annotations to map to the corresponding database table "friends"
public class Friend { // Friend: a class to represent the relationship between two users who are
						// friends

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long friendshipId;

	@ManyToOne
	@JoinColumn(name = "user_id_1", nullable = false) // "user1" is required field and cannot be null
	private User user1;

	@ManyToOne
	@JoinColumn(name = "user_id_2", nullable = false) // "user2" is required field and cannot be null
	private User user2;

	@Column(name = "created_at", nullable = false) // "createdAt" is required field and cannot be null
	private LocalDateTime createdAt;

	public Long getFriendshipId() {
		return friendshipId;
	}

	public void setFriendshipId(Long friendshipId) {
		this.friendshipId = friendshipId;
	}

	public User getUser1() {
		return user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	// private String status;
	// private String notes;

}
