package com.standard.api.order.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class OrderDetailQueryResponse {

    @ApiModelProperty("订单编号")
    private String orderId;

    @ApiModelProperty("订单详情")
    private String goodsinfo;



}