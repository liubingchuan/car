package com.car.app.common;

public class DataResponse<T> extends BaseResponse {

    private static final long serialVersionUID = 1L;

    private T                 data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
