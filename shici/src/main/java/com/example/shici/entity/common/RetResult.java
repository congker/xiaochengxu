/**
 * @description:函数描述
 * @author: winson
 * @time: ${Date}
 */
package com.example.shici.entity.common;

import lombok.Data;

@Data
public class RetResult<T> {
    public int code;

    private String msg;

    private T data;

    public RetResult<T> setCode(RetCode retCode) {
        this.code = retCode.code;
        return this;
    }


    public RetResult<T> setCode(int code) {
        this.code = code;
        return this;
    }


    public RetResult<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public RetResult<T> setData(T data) {
        this.data = data;
        return this;
    }
}
