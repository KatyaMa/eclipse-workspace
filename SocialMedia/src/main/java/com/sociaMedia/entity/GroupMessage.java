package com.sociaMedia.entity;

import java.io.Serializable;
import java.util.Date;

public class GroupMessage implements Serializable{

    private Long id;
    private Long groupId;
    private Long userId;
	private String message;
    private Date createdAt;

}
