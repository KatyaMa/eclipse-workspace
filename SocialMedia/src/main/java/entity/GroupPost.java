package entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "likes")     // annotations to map to the corresponding database table "likes"

public class GroupPost {

    private Long id;
    private Long groupId;
    private Long userId;
	private String message;
    private Date createdAt;

}
