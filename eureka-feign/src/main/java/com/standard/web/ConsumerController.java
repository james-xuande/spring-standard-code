package com.standard.web;

import com.standard.api.order.request.OrderDetailQueryRequest;
import com.standard.api.order.response.OrderDetailQueryResponse;
import com.standard.service.OrderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    OrderClient computeClient;

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public OrderDetailQueryResponse getOrderInfo(@RequestBody OrderDetailQueryRequest request) {
        OrderDetailQueryRequest requestVo  = new OrderDetailQueryRequest();
        requestVo.setName("james");
        requestVo.setOrderId("111");
        return computeClient.orderQuery(requestVo);
    }

}