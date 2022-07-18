package com.qf.commons.core.exception;


import lombok.Data;

@Data
public class ServiceException extends RuntimeException{
    private Integer code;
    private String msg;
    public ServiceException(Integer code, String msg){
        this.code=code;
        this.msg=msg;
    }
}
