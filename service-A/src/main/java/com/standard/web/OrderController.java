package com.standard.web;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.standard.api.order.OrderDetailQueryApi;
import com.standard.api.order.request.OrderDetailQueryRequest;
import com.standard.api.order.response.OrderDetailQueryResponse;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;



@RestController
public class OrderController implements OrderDetailQueryApi {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);



    public OrderDetailQueryResponse orderQuery(@Valid @RequestBody OrderDetailQueryRequest requestVo) {
        logger.info("==>订单详情查询接口 请求数据:" + JSON.toJSONString(requestVo));
        OrderDetailQueryResponse restResponse = new OrderDetailQueryResponse();
        restResponse.setOrderinfo("这是xxx的订单详情");
        restResponse.setOrderId(requestVo.getOrderId());
        logger.info("<==订单详情查询接口 返回数据:" + JSON.toJSONString(restResponse));
        return restResponse;
    }
}