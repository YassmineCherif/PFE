package com.isg.orderService.config;

import com.isg.orderService.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "product-service")
public interface ProductResourceFeign {
    @RequestMapping("updateProductQuantity")
    Product updateQuantity(@RequestParam String product,@RequestParam int quantity,@RequestParam boolean b);


}
