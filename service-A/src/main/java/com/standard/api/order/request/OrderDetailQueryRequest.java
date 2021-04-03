package com.standard.api.order.request;


import com.sun.istack.internal.NotNull;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Size;


@Data
public class OrderDetailQueryRequest {

    @ApiModelProperty("订单编号")
    private String orderId;

    @NotNull
    @Size(min = 2, max = 10)
    @ApiModelProperty("用户姓名")
    private String name;


}
