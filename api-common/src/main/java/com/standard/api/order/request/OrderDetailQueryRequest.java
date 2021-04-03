package com.standard.api.order.request;


import com.sun.istack.internal.NotNull;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Size;


@Data
public class OrderDetailQueryRequest {

    //字段解释，会显示在 swagger接口文档中
    @ApiModelProperty("订单编号")
    private String orderId;

    //字段非空校验
    @NotNull
    //字段长度校验
    @Size(min = 2, max = 10)
    //字段解释，会显示在 swagger接口文档中
    @ApiModelProperty("用户姓名")
    private String name;


}
