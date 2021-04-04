package com.standard.web;

import com.alibaba.fastjson.JSON;
import com.standard.api.order.request.OrderDetailQueryRequest;
import com.standard.api.order.response.OrderDetailQueryResponse;
import com.standard.service.OrderClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ConsumerController {
    private static final Logger logger = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    OrderClient computeClient;

    @RequestMapping(value = "/order/query", method = RequestMethod.POST)
    public OrderDetailQueryResponse getOrderInfo(@RequestBody OrderDetailQueryRequest request) {
        OrderDetailQueryResponse response = null;
        logger.info("订单查询请求参数：" + JSON.toJSONString(request));

        try {
            response = computeClient.orderQuery(request);
        } catch (Exception e) {
            logger.error("订单查询返回异常：" + e);
        }
        logger.info("订单查询返回参数：" + JSON.toJSONString(response));

        return response;
    }

    @RequestMapping(value = "/order/create", method = RequestMethod.POST)
    public OrderDetailQueryResponse createOrder(@RequestBody OrderDetailQueryRequest request) {
        logger.info("订单创建请求参数：" + JSON.toJSONString(request));

        char[] data = new char[50000];//1char=2b, 500char=1000b=1kb,   50000char=100kb

        OrderDetailQueryResponse response = null;
        request.setOrderinfo(new String(data));
        try {
            response = computeClient.orderCreate(request);
        } catch (Exception e) {
            logger.error("订单创建返回异常：" + e);
        }
        logger.info("订单创建返回参数：" + JSON.toJSONString(response));

        return response;
    }
}