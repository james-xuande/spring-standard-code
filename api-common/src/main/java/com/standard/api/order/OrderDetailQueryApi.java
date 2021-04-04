package com.standard.api.order;

import com.standard.api.order.request.OrderDetailQueryRequest;
import com.standard.api.order.response.OrderDetailQueryResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//restful接口 聚焦于资源 ,接口资源解释
@Api(tags = "订单order模块")
public interface OrderDetailQueryApi {
    //接口名称
    @ApiOperation(value = "订单详情查询接口", notes = "根据订单ID查询订单")
    //springboot2 带的post注解
    @RequestMapping(value = "/order/detailquery",method = RequestMethod.POST)
    //这里valid 进行参数校验生效，具体校验信息在requestVo中注解实现校验
    OrderDetailQueryResponse orderQuery(OrderDetailQueryRequest requestVo) throws InterruptedException;


    //接口名称
    @ApiOperation(value = "订单创建接口", notes = "订单创建")
    //springboot2 带的post注解
    @RequestMapping(value = "/order/create_to_db",method = RequestMethod.POST)
    //这里valid 进行参数校验生效，具体校验信息在requestVo中注解实现校验
    OrderDetailQueryResponse orderCreate(OrderDetailQueryRequest requestVo);

}
