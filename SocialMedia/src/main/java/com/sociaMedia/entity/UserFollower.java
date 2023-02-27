package com.sociaMedia.entity;

import java.io.Serializable;
import java.util.Date;

public class UserFollower {

	private Long id;
	private Long sourceId;
	private Long targetId;
	private String type; // Type to classify followers. Like, Dislike, Follow
//	private Date createdAt;
}
