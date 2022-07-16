package com.qf.data.base.r;

import com.ken.mybatis.protocol.BaseResult;
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
}
