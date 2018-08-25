package com.car.app.common;


public class ResponseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private BaseResponse      response;

    public ResponseException() {
        super();
    }

    public ResponseException(String message) {
        super(message);
        BaseResponse response = new BaseResponse();
        response.setErrorResponse(ResponseCode.InternalServerError_$$, "Service", message);
        this.response = response;
    }

    public ResponseException(Throwable e) {
        super(e);
        BaseResponse response = new BaseResponse();
        response.setErrorResponse(ResponseCode.InternalServerError_$$, e.getClass().getSimpleName(), e.getMessage());
        this.response = response;
    }

    public ResponseException(String message, Throwable e) {
        super(message, e);
        BaseResponse response = new BaseResponse();
        response.setErrorResponse(ResponseCode.InternalServerError_$$, e.getClass().getSimpleName(), message);
        this.response = response;
    }

    public ResponseException(ResponseCode responseCode, Object... args) {
        BaseResponse response = new BaseResponse();
        response.setErrorResponse(responseCode, args);
        this.response = response;
    }

    public ResponseException(Throwable e, ResponseCode responseCode, Object... args) {
        super(e);
        BaseResponse response = new BaseResponse();
        response.setErrorResponse(responseCode, args);
        this.response = response;
    }

    public ResponseException(BaseResponse response) {
        super(response.getMessage());
        this.response = response;
    }

    public ResponseException(BaseResponse response, Throwable e) {
        super(response.getMessage(), e);
        this.response = response;
    }

    public BaseResponse getResponse() {
        return response;
    }
    
    @Override
    public String getMessage() {
        return getResponse().getMessage();
    }
    
    public static void main(String[] args) {
    	String code = String.format("123123123", "adf");
    	System.out.println(code);
	}

}
