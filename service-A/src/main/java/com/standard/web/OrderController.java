package com.standard.web;


import com.alibaba.fastjson.JSON;

import com.standard.api.order.OrderDetailQueryApi;
import com.standard.api.order.request.OrderDetailQueryRequest;
import com.standard.api.order.response.OrderDetailQueryResponse;
import com.standard.service.OrderService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
//对于接口，实现api interface 即可，对应字段注解 放在interface
public class OrderController implements OrderDetailQueryApi {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    OrderService orderService = new OrderService();


    public OrderDetailQueryResponse orderQuery(@Valid @RequestBody OrderDetailQueryRequest requestVo) throws InterruptedException {

        logger.info("==>订单详情查询接口 请求数据:" + JSON.toJSONString(requestVo));
        OrderDetailQueryResponse restResponse = new OrderDetailQueryResponse();
        OrderDetailQueryRequest db_resp = orderService.get_order(requestVo.getOrderId());
        if (db_resp != null) {
            restResponse.setCode("200");
            restResponse.setCodeDesc("订单查询成功");
            restResponse.setOrderinfo(db_resp.getName());
            restResponse.setOrderId(db_resp.getOrderId());
            logger.info("<==订单详情查询接口 返回数据:" + JSON.toJSONString(restResponse));
            return restResponse;
        }


        restResponse.setCode("9999");
        restResponse.setCodeDesc("订单不存在");
        logger.info("<==订单详情查询接口 订单不存在 返回数据:" + JSON.toJSONString(restResponse));

        return restResponse;
    }

    @Override
    public OrderDetailQueryResponse orderCreate(@Valid @RequestBody OrderDetailQueryRequest requestVo) {
        logger.info("==>订单详情创建接口 请求数据:" + JSON.toJSONString(requestVo));
        OrderDetailQueryResponse restResponse = orderService.create_order(requestVo);
        logger.info("<==订单创建接口 返回数据:" + JSON.toJSONString(restResponse));
        return restResponse;
    }
}