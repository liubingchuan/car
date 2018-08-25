package com.car.app.common;

import java.util.List;

public class ListResponse<T> extends BaseResponse {

    private static final long serialVersionUID = 1L;

    /** 结果列表 */
    private List<T>           data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

}
