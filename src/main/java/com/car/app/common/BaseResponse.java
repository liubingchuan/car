package com.car.app.common;


import java.io.Serializable;

import com.car.app.utils.ErrorCode;

public class BaseResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 成功：true，失败：false */
	private boolean successResponse = false;

	/** 错误代码，成功：200 */
	private String code = "";

	private String level;

	private String key;

	/** 错误提示信息 */
	private String message;

	/** 请求ID */
	private String requestId;

	/** 花费时间，单位毫秒（ms） */
	private long cost;

	public BaseResponse() {
		this.successResponse = true;
		this.code = "200";
		this.message = "success";
	}

	public void copy(BaseResponse response) {
		this.successResponse = response.isSuccessResponse();
		this.code = response.getCode();
		this.message = response.getMessage();
	}

	public void setErrorResponse(ResponseCode responseCode, Object... args) {
		if (args.length == 0) {
			args = new Object[] { "--", "--" };
		} else if (args.length == 1) {
			args = new Object[] { args[0], "--" };
		}

		this.successResponse = false;
		this.code = responseCode.code;
		this.message = String.format(responseCode.message, args);
	}

	public void setErrorResponse(String code, String message) {
		this.successResponse = false;
		this.code = code;
		this.message = message;
	}

	public void setErrorResponse(String code, String message, ErrorCode errorCode) {
		this.successResponse = false;
		this.code = code;
		this.message = message;
		this.key = errorCode.key;
		this.level = errorCode.level;
	}

	public void setErrorResponse(String code, String message, Object... args) {
		this.successResponse = false;
		this.code = code;
		this.message = String.format(message, args);
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public boolean isSuccessResponse() {
		return successResponse;
	}

	public void setSuccessResponse(boolean successResponse) {
		this.successResponse = successResponse;
	}
	public boolean getSuccessResponse() {
		return this.successResponse;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getCost() {
		return cost;
	}

	public void setCost(long cost) {
		this.cost = cost;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "BaseResponse{" +
			"successResponse=" + successResponse +
			", code='" + code + '\'' +
			", level='" + level + '\'' +
			", key='" + key + '\'' +
			", message='" + message + '\'' +
			", requestId='" + requestId + '\'' +
			", cost=" + cost +
			'}';
	}
}
