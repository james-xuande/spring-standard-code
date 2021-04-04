package com.standard.service;

import com.standard.api.order.OrderDetailQueryApi;
import com.standard.api.order.request.OrderDetailQueryRequest;
import com.standard.api.order.response.OrderDetailQueryResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


//这里只需要继承nexus通用api jar 就可以调用service-A
@FeignClient("service-A")
public interface OrderClient extends OrderDetailQueryApi {

}