package com.car.app.model;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

public class ErrorLog implements Serializable{


	@JSONField(name="ErrorId")
	private String errorId;          // 实例状态值
	
	@JSONField(name="ErrorInfo")
	private String errorInfo;    // 实例ID
	
	@JSONField(name="CreateTime")
	private String createTime;         //  实例使用类型，0 常规实例，1 子实例，2 灾备实例，3只读实例

	public String getErrorId() {
		return errorId;
	}

	public void setErrorId(String errorId) {
		this.errorId = errorId;
	}

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	
}
