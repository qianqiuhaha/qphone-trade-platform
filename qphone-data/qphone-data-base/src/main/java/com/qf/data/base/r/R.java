package com.qf.data.base.r;

import com.ken.mybatis.protocol.BaseResult;
import com.qf.commons.core.exception.ServiceException;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class R<T> extends BaseResult<T> implements Serializable {
    //响应码
    private Integer code;
    //生成相应的信息
    private String msg;
    //数据部分
    private T data;

    public  T result(){
        if (this.getCode().intValue()==Codes.SUCC.getCode()){
            return this.getData();
        }else {
            //手动抛出异常
            throw new ServiceException(Codes.FAIL.getCode(), Codes.FAIL.getMsg());
        }
    }
}
