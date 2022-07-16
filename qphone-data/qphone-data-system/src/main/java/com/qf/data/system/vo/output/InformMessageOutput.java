package com.qf.data.system.vo.output;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author qiu16
 */
public class InformMessageOutput implements Serializable {
    //文章的标题信息
    private String message;
    //文章的内容
    private String content;
}
