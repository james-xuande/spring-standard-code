package com.standard.web;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.standard.api.order.request.OrderDetailQueryRequest;
import com.standard.api.order.response.OrderDetailQueryResponse;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = "订单order模块")
@RestController
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);


    @ApiOperation(value = "订单详情查询接口", notes = "根据订单ID查询订单")
    @RequestMapping(value = "/order/detailquery", method = RequestMethod.POST)
    public OrderDetailQueryResponse orderQuery(@Valid @RequestBody OrderDetailQueryRequest requestVo) {
        logger.info("==>订单详情查询接口 请求数据:" + JSON.toJSONString(requestVo));


        OrderDetailQueryResponse restResponse = new OrderDetailQueryResponse();
        restResponse.setGoodsinfo("这是个好商品");
        restResponse.setOrderId(requestVo.getOrderId());

        logger.info("<==订单详情查询接口 返回数据:" + JSON.toJSONString(restResponse));
        return restResponse;
    }
}