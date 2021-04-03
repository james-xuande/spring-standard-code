package com.standard.web;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.standard.api.order.request.OrderDetailQueryRequest;
import com.standard.api.order.response.OrderDetailQueryResponse;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//restful接口 聚焦于资源 ,接口资源解释
@Api(tags = "订单order模块")
@RestController
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);


    //接口名称
    @ApiOperation(value = "订单详情查询接口", notes = "根据订单ID查询订单")
    //springboot2 带的post注解
    @PostMapping(value = "/order/detailquery")
    //这里valid 进行参数校验生效，具体校验信息在requestVo中注解实现校验
    public OrderDetailQueryResponse orderQuery(@Valid @RequestBody OrderDetailQueryRequest requestVo) {
        logger.info("==>订单详情查询接口 请求数据:" + JSON.toJSONString(requestVo));


        OrderDetailQueryResponse restResponse = new OrderDetailQueryResponse();
        restResponse.setOrderinfo("这是xxx的订单详情");
        restResponse.setOrderId(requestVo.getOrderId());

        logger.info("<==订单详情查询接口 返回数据:" + JSON.toJSONString(restResponse));
        return restResponse;
    }
}