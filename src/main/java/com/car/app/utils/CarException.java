package com.car.app.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import com.car.app.common.BaseResponse;
import com.car.app.service.impl.AbstractCarService;

public class CarException extends RuntimeException{
	ResponseEntity<String>  re;
	
	public CarException() {
		super();
	}

	public CarException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CarException(String message, Throwable cause) {
		super(message, cause);
	}

	public CarException(String message) {
		super(message);
	}

	public CarException(Throwable cause) {
		super(cause);
	}
    /**
     * 为 系统adapter aso 准备的异常处理类，处理调用接口所返回来的结果
     * @param re
     * @param message
     */
	public CarException(ResponseEntity<String> re,String message) {
		super(message);
		this.re = re;
	}
	 public static void setErrInfo(BaseResponse response,ErrorCode err, Exception e) {
			String str ="";
	    	if(e!=null) {
				str =err.cn+"具体详情："+e.getMessage();
				AbstractCarService.logger.error(e.getMessage());
				
			}
	    	if(e!=null||StringUtil.isNull(response.getCode())) {  //针对异常处理的方式，给code赋值，响应正常的话在正常块中赋值
	    		if(e instanceof CarException) {  //esc 中的代码错误
	        		response.setCode("500");
	        	}else if(e==null&&!StringUtil.isNull(response.getCode())) {  //嫦娥api中直接返回的状态码
	        		response.setCode(response.getCode());
	        	}else {  //未知错误
	        		response.setCode("301");
	        	}
	    	}
	    	if(e!=null||StringUtil.isNull(response.getMessage())) {
	    		response.setMessage(str);
	    	}
			response.setKey(err.key);
			response.setLevel(err.level);
			if(!"200".equals(response.getCode())) {
				response.setSuccessResponse(false);
			}
		}

}
