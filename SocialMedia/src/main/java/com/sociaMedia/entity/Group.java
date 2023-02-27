package com.sociaMedia.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "groups") // annotations to map to the corresponding database table "groups"
public class Group {    // Group: a class to represent groups of users who have a shared interest

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne // Group class has a many-to-one relationship with the User class, so each group
				// has an author
	@JoinColumn(name = "created_by_user_id", nullable = false)
	private User createdBy; // The "createdBy" field in the Group class is a User object and is mapped to
							// the "created_by_user_id" foreign key column in the database table

	@Column(name = "title", nullable = false) // "title" is a required field and cannot be null
	private String title;

	@ManyToMany // relationships with User
	@JoinTable(name = "users_groups", joinColumns = @JoinColumn(name = "group_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private Set<User> users = new HashSet<>();

	@Column(name = "created_at", nullable = false) // "created_at" is required field and cannot be null
	private LocalDateTime createdAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

//	private String profile;
//	private String content;

}
