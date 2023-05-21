package com.isg.UserService.config;

import com.isg.UserService.model.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@FeignClient(name = "order-service", url = "order:8070")
public interface OrderResourceFeign {
    @GetMapping("/OrdersBySeller/{id}")
    List<Order> getOrdersBySeller(@PathVariable("id") String id);
    @GetMapping("/OrdersByCustomer/{id}")
    List<Order> getOrdersByCustomer(@PathVariable("id") String id);


}