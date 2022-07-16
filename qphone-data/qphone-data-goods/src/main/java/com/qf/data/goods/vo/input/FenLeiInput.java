package com.qf.data.goods.vo.input;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
@Data
public class FenLeiInput implements Serializable {
    private Long pid;
    @NotBlank(message = "分类名称不能为空！")
    private String fenleiName;

}
