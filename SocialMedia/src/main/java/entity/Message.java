package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "messages")     // annotations to map to the corresponding database table "messages"
public class Message {        // Message: a class to represent messages sent between users

	private Long id;
	private Long sourceId;
	private Long targetId;
	private String message;
//	private Date createdAt;

}
