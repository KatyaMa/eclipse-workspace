package com.sociaMedia.entity;

import java.io.Serializable;
import java.util.Date;

public class groupFollower implements Serializable {

    private Long id;
    private Long groupId;
    private Long userId;
    private String type; // The follower type. Like, Dislike, Follow
    private Date createdAt;
}
