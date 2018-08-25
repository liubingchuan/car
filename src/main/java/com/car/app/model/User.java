package com.car.app.model;

import com.car.app.annotation.IdFlag;
import com.car.app.annotation.TableName;

@TableName("rds_user")
public class User {

	public User() {
		
	}
	
	@IdFlag
	private Integer id;
	private String uid;
	private String userId;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
