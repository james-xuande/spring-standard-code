package com.standard.service;

import com.standard.api.order.request.OrderDetailQueryRequest;
import com.standard.api.order.response.OrderDetailQueryResponse;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class OrderService {
    private static final ConcurrentHashMap<String, OrderDetailQueryRequest> local_order_db = new ConcurrentHashMap<>();

    public OrderDetailQueryResponse create_order(OrderDetailQueryRequest order) {
        OrderDetailQueryResponse restResponse = new OrderDetailQueryResponse();
        //幂等性校验，不重复创建订单
        if (order.getOrderId()!= null && local_order_db.get(order.getOrderId()) == null) {
            //反例：这里请替换成mysql数据库，否则根据gc root 算法 ，local_order_db 一直引用，会撑满 老年代内存会发生jvm 溢出。
            local_order_db.put(order.getOrderId(), order);
            restResponse.setCode("200");
            restResponse.setCodeDesc("订单查询成功");
        } else {
            restResponse.setCode("9998");
            restResponse.setCodeDesc("订单重复创建");
        }
        return restResponse;

    }

    public OrderDetailQueryRequest get_order(String id) {
        if (id != null && id.length() > 0) {
            OrderDetailQueryRequest request = local_order_db.get(id);
            return request;
        } else {
            return null;
        }
    }

}
