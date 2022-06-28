package com.dz.springboard.util;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

//@Getter
//@Setter
@Data
public class JsonResult<E> implements Serializable {
    private Integer state;

    private String message;

    private E data;

    public JsonResult() {
        super();
    }

    public JsonResult(Integer state) {
        super();
        this.state = state;
    }

    public JsonResult(Throwable e) {
        super();
        // 获取异常对象中的异常信息
        this.message = e.getMessage();
    }

    public JsonResult(Integer state, E data) {
        super();
        this.state = state;
        this.data = data;
    }

    public JsonResult(Integer state, String message) {
        super();
        this.state = state;
        this.message = message;
    }

    public JsonResult(Integer state, String message, E data) {
        super();
        this.state = state;
        this.message = message;
        this.data = data;
    }
}
