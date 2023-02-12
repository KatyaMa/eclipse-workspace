package entity;

import java.time.LocalDateTime;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users") // annotations to map to the corresponding database table "users"
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false) // "name" is required field and cannot be null
	private String name;

	@Column(name = "email", nullable = false) // "email" is required field and cannot be null
	private String email;

	@Column(name = "password", nullable = false) // "password" is required field and cannot be null
	private String password;

	@Column(name = "registeredAt", nullable = false) // "registeredAt" is required field and cannot be null
	private LocalDateTime registeredAt;
	
	@Column(name = "profile_picture")
    private String profilePicture;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	// the password setter uses the BCryptPasswordEncoder to hash and salt the password before storing it in the database
	public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }

	public LocalDateTime getRegisteredAt() {
		return registeredAt;
	}

	public void setRegisteredAt(LocalDateTime registeredAt) {
		this.registeredAt = registeredAt;
	}
    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }


//	private Date lastLogin;
//	private String intro;

}
