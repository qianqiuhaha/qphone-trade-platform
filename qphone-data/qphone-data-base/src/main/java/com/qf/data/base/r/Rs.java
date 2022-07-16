package com.qf.data.base.r;

import com.sun.org.apache.bcel.internal.classfile.Code;

public class Rs {
    //返回成功的R对象
    public static <T> R<T> create(T data){
        return new R<T>().setCode(Codes.SUCC.getCode())
                .setMsg(Codes.SUCC.getMsg()).setData(data);
    }
    //返回失败的R对象
    public static <T> R<T> createFail(Codes codes){
        return  createFail(codes,null);
    }
    //返回失败的R对象
    public static <T> R<T> createFail(Codes codes,T data){
        return new R<T>().setCode(codes.getCode())
                .setMsg(codes.getMsg()).setData(data);
    }

}
